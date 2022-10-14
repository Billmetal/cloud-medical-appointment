package br.com.homework.bill.cloudmedicalappointment.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.homework.bill.cloudmedicalappointment.model.Appointment;
import br.com.homework.bill.cloudmedicalappointment.model.dto.AppointmentDTO;
import br.com.homework.bill.cloudmedicalappointment.model.mapper.AppointmentMapper;
import br.com.homework.bill.cloudmedicalappointment.service.AppointmentService;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
	
	private final AppointmentService appointmentService;
	private final AppointmentMapper appointmentMapper;

	public AppointmentController(AppointmentService appointmentService,AppointmentMapper appointmentMapper) {
		this.appointmentService = appointmentService;
		this.appointmentMapper = appointmentMapper;
	}


	@GetMapping
	public List<AppointmentDTO> findAll(){
		List<Appointment> appointmentList = appointmentService.findAll();
		List<AppointmentDTO> result = appointmentMapper.toAppointmentDTOList(appointmentList);
		return result;
	}
}
