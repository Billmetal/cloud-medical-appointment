package br.com.homework.bill.cloudmedicalappointment.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class AppointmentNotFundException extends RuntimeException {

	private static final long serialVersionUID = -4331009192775201782L;

	public AppointmentNotFundException(String id) {
		super("Appointment not found with id : " + id);
	}
}
