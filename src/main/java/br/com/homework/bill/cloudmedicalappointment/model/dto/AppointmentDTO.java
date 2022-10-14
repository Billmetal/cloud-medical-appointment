package br.com.homework.bill.cloudmedicalappointment.model.dto;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;

import br.com.homework.bill.cloudmedicalappointment.enums.AppointmentType;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AppointmentDTO {

	private String hash;
	
	private Long id;
	
	private Long patientId;
	
	private AppointmentType appointmentType;
	
	private String doctorName;
	
	private String medicalSpecialty;
	
	private String diagnosis;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime entryDate;
	
	@JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss")
	private LocalDateTime exitDate;
	
	private Double bill;

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
