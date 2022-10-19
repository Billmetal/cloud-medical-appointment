package br.com.homework.bill.cloudmedicalappointment.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import br.com.homework.bill.cloudmedicalappointment.exceptions.AppointmentNotFundException;
import br.com.homework.bill.cloudmedicalappointment.model.Appointment;
import br.com.homework.bill.cloudmedicalappointment.repository.AppointmentRepository;

@Service
public class AppointmentService {

	private final AppointmentRepository appointmentRepository;
	

	public AppointmentService(AppointmentRepository appointmentRepository) {
		this.appointmentRepository = appointmentRepository;
	}

	private static String getUUID() {
		return UUID.randomUUID().toString().replace("-","");
	}
	
	@Transactional(readOnly = true,propagation = Propagation.SUPPORTS)
	public List<Appointment> findAll(){
		return appointmentRepository.findAll();
	}

	@Transactional(readOnly = true)
	public Appointment findById(String id) {
		return appointmentRepository.findById(id).orElseThrow(() -> new AppointmentNotFundException(id));
	}

	@Transactional
	public Appointment create(Appointment appointment) {
		String hash = getUUID();
		appointment.setHash(hash);
		appointment.setEntryDate(LocalDateTime.now());
		return appointmentRepository.save(appointment);
	}

	@Transactional
	public void delete(String id) {
		findById(id);
		appointmentRepository.deleteById(id);
	}

	@Transactional
	public Appointment update(String id, Appointment appointment) {
		Appointment byId = findById(id);
		byId.setAppointmentType(appointment.getAppointmentType());
		byId.setDoctorName(appointment.getDoctorName());
		byId.setMedicalSpecialty(appointment.getMedicalSpecialty());
		byId.setBill(appointment.getBill());
		byId.setDiagnosis(appointment.getDiagnosis());
		byId.setPatientId(appointment.getPatientId());
		byId.setClinicId(appointment.getClinicId());
		byId.setEntryDate(appointment.getEntryDate());
		byId.setExitDate(appointment.getExitDate());	
		return appointmentRepository.save(byId);
	}

	@Transactional
	public Appointment end(String id) {
		Appointment appointment = findById(id);
		appointment.setDiagnosis("Parecer médico sobre esta consulta, como diagnóstico , próxima fase de tratamento e "
				+ "medicação a ser tomada pelo paciente .");
		appointment.setExitDate(LocalDateTime.now());
		appointment.setBill(AppointmentCheckOut.getBill(appointment));
		return appointmentRepository.save(appointment);
	}

}
