package br.com.homework.bill.cloudmedicalappointment.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.homework.bill.cloudmedicalappointment.exceptions.AppointmentNotFundException;
import br.com.homework.bill.cloudmedicalappointment.model.Appointment;

@Service
public class AppointmentService {

	private static Map<String,Appointment> appointmentMap = new HashMap<>();

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

	public Appointment end(String id) {
		Appointment appointment = findById(id);
		appointment.setDiagnosis("Parecer médico sobre esta consulta, como diagnóstico , próxima fase de tratamento e "
				+ "medicação a ser tomada pelo paciente .");
		appointment.setBill(250.00);
		appointment.setExitDate(LocalDateTime.now());
		appointmentMap.replace(id, appointment);
		return appointment;
	}

}
