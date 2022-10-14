package br.com.homework.bill.cloudmedicalappointment.model;

import java.time.LocalDateTime;

import br.com.homework.bill.cloudmedicalappointment.enums.AppointmentType;

public class Appointment {

	private String hash;
	
	private Long id;
	
	private Long patientId;
	
	private AppointmentType appointmentType;
	
	private String doctorName;
	
	private String medicalSpecialty;
	
	private String diagnosis;
	
	private LocalDateTime entryDate;
	
	private LocalDateTime exitDate;
	
	private Double bill;
	
	public Appointment() {
		
	}

	public Appointment(String hash, Long patientId, AppointmentType appointmentType, String doctorName,
			String medicalSpecialty) {
		this.hash = hash;
		this.patientId = patientId;
		this.appointmentType = appointmentType;
		this.doctorName = doctorName;
		this.medicalSpecialty = medicalSpecialty;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getPatientId() {
		return patientId;
	}

	public void setPatientId(Long patientId) {
		this.patientId = patientId;
	}

	public AppointmentType getAppointmentType() {
		return appointmentType;
	}

	public void setAppointmentType(AppointmentType appointmentType) {
		this.appointmentType = appointmentType;
	}

	public String getDoctorName() {
		return doctorName;
	}

	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public String getMedicalSpecialty() {
		return medicalSpecialty;
	}

	public void setMedicalSpecialty(String medicalSpecialty) {
		this.medicalSpecialty = medicalSpecialty;
	}

	public String getDiagnosis() {
		return diagnosis;
	}

	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}

	public LocalDateTime getEntryDate() {
		return entryDate;
	}

	public void setEntryDate(LocalDateTime entryDate) {
		this.entryDate = entryDate;
	}

	public LocalDateTime getExitDate() {
		return exitDate;
	}

	public void setExitDate(LocalDateTime exitDate) {
		this.exitDate = exitDate;
	}

	public Double getBill() {
		return bill;
	}

	public void setBill(Double bill) {
		this.bill = bill;
	}
	
	
}
