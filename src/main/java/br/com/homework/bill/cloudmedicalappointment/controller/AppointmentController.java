package br.com.homework.bill.cloudmedicalappointment.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.homework.bill.cloudmedicalappointment.model.Appointment;
import br.com.homework.bill.cloudmedicalappointment.model.dto.AppointmentCreateDTO;
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
	public ResponseEntity<List<AppointmentDTO>> findAll(){
		List<Appointment> appointmentList = appointmentService.findAll();
		List<AppointmentDTO> result = appointmentMapper.toAppointmentDTOList(appointmentList);
		return ResponseEntity.ok(result);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<AppointmentDTO> findById(@PathVariable String id){
		Appointment appointment = appointmentService.findById(id);
		AppointmentDTO result = appointmentMapper.toAppointmentDTO(appointment);
		return ResponseEntity.ok(result);
	}
	
	@PostMapping
	public ResponseEntity<AppointmentDTO> create(@RequestBody AppointmentCreateDTO appointmentCreateDTO){
		Appointment appointment = appointmentMapper.toAppointment(appointmentCreateDTO);
		Appointment appointmentSaved = appointmentService.create(appointment);
		AppointmentDTO result = appointmentMapper.toAppointmentDTO(appointmentSaved);
		return ResponseEntity.status(HttpStatus.CREATED).body(result);
	}
}
