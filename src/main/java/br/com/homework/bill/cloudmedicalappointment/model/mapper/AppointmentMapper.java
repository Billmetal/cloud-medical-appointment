package br.com.homework.bill.cloudmedicalappointment.model.mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import br.com.homework.bill.cloudmedicalappointment.model.Appointment;
import br.com.homework.bill.cloudmedicalappointment.model.dto.AppointmentCreateDTO;
import br.com.homework.bill.cloudmedicalappointment.model.dto.AppointmentDTO;

@Component
public class AppointmentMapper {
	
	private static final ModelMapper MODEL_MAPPER = new ModelMapper(); 
	
	public AppointmentDTO toAppointmentDTO(Appointment appointment) {
		return MODEL_MAPPER.map(appointment,AppointmentDTO.class);
	}

	public List<AppointmentDTO> toAppointmentDTOList(List<Appointment> appointmentList) {
		return appointmentList.stream().map(this::toAppointmentDTO).collect(Collectors.toList());
	}

	public Appointment toAppointment(AppointmentDTO appointmentDTO) {
		return MODEL_MAPPER.map(appointmentDTO,Appointment.class);
	}

	public Appointment toAppointment(AppointmentCreateDTO appointmentCreateDTO) {
		return MODEL_MAPPER.map(appointmentCreateDTO,Appointment.class);
	}

}
