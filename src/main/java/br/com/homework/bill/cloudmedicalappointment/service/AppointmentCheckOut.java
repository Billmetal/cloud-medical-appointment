package br.com.homework.bill.cloudmedicalappointment.service;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

import br.com.homework.bill.cloudmedicalappointment.enums.AppointmentType;
import br.com.homework.bill.cloudmedicalappointment.model.Appointment;

public class AppointmentCheckOut {
	
	private static final int FORTY_MINUTES = 40;
	private static final int TEN_MINUTES = 10;
	private static final double APPOINTMENT_VALUE = 150.00;
	private static final double EXAM_VALUE = 80.00;
	private static final double TREATMENT_VALUE = 60.00;

	public static Double getBill(Appointment appointment) {
		return getBill(appointment.getAppointmentType(),appointment.getEntryDate(),appointment.getExitDate());
	}

	private static Double getBill(AppointmentType type,LocalDateTime entryDate, LocalDateTime exitDate) {
		long minutes = entryDate.until(exitDate, ChronoUnit.MINUTES);
		switch(type) {
			case APPOINTMENT:
				if(minutes <= TEN_MINUTES) {
					return discount(APPOINTMENT_VALUE);
				}
				if(minutes >= FORTY_MINUTES) {
					return add(APPOINTMENT_VALUE);
				}
				return APPOINTMENT_VALUE;
			case EXAM:  
				return EXAM_VALUE;
			case TREATMENT:  
				return TREATMENT_VALUE;	
			default:
				return null;
		}
	}
	
	private static Double add(double value) {
		return value + tenPorcent(value);
	}
	
	private static Double discount(double value) {
		return value - tenPorcent(value);
	}
	
	private static Double tenPorcent(double value) {
		return (value * 10) / 100;
	}
}
