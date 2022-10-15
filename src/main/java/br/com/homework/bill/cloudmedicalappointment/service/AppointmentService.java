package br.com.homework.bill.cloudmedicalappointment.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.homework.bill.cloudmedicalappointment.enums.AppointmentType;
import br.com.homework.bill.cloudmedicalappointment.exceptions.AppointmentNotFundException;
import br.com.homework.bill.cloudmedicalappointment.model.Appointment;

@Service
public class AppointmentService {

	private static Map<String,Appointment> appointmentMap = new HashMap<>();
	
	static {
		String hash = getUUID();
		Appointment appointment = new Appointment(hash,455L,AppointmentType.APPOINTMENT,"Dr. Roger Lin","Clínico Geral");
		appointmentMap.put(hash, appointment);
		hash = getUUID();
		appointment = new Appointment(hash,202L,AppointmentType.APPOINTMENT,"Dr. Rosangela Lemos","Ortopedia");
		appointmentMap.put(hash, appointment);
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
	public List<Appointment> findAll(){
		return appointmentMap.values().stream().collect(Collectors.toList());
	}

	public Appointment findById(String id) {
		Appointment appointment = appointmentMap.get(id);
		if(appointment == null) {
			throw new AppointmentNotFundException(id);
		}
		return appointment;
	}

	public Appointment create(Appointment appointment) {
		String hash = getUUID();
		appointment.setHash(hash);
		appointment.setEntryDate(LocalDateTime.now());
		appointmentMap.put(hash, appointment);
		return appointment;
	}

	public void delete(String id) {
		findById(id);
		appointmentMap.remove(id);
	}

	public Appointment update(String id, Appointment appointment) {
		Appointment byId = findById(id);
		byId.setAppointmentType(appointment.getAppointmentType());
		byId.setDoctorName(appointment.getDoctorName());
		byId.setMedicalSpecialty(appointment.getMedicalSpecialty());
		appointmentMap.replace(id, byId);
		return byId;
	}

}
