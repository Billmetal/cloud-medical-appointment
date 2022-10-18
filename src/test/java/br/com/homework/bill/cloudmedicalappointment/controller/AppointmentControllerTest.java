package br.com.homework.bill.cloudmedicalappointment.controller;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import br.com.homework.bill.cloudmedicalappointment.enums.AppointmentType;
import br.com.homework.bill.cloudmedicalappointment.model.dto.AppointmentCreateDTO;
import io.restassured.RestAssured;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class AppointmentControllerTest {
	
	@LocalServerPort
	private int randomPort;
	
	@BeforeEach
	public void setUpTest() {
		RestAssured.port = randomPort;
	}

	@Test
	void whenFindAllThenCheckResult() {
		RestAssured.given().when()
			.get("/appointment")
			.then()
			.statusCode(HttpStatus.OK.value());
	}

	@Test
	void whenCreateThenCheckIsCreated() {
		var createDTO = new AppointmentCreateDTO();
		createDTO.setAppointmentType(AppointmentType.EXAM);
		createDTO.setDoctorName("Paulo Ricardo");
		createDTO.setMedicalSpecialty("Radiografia");
		createDTO.setPatientId(2100L);
		
		RestAssured.given().when()
		.contentType(MediaType.APPLICATION_JSON_VALUE)
		.body(createDTO)
		.post("/appointment")
		.then()
		.statusCode(HttpStatus.CREATED.value())
		.body("medicalSpecialty",Matchers.equalTo("Radiografia"))
		.body("patientId",Matchers.equalTo(2100));
	}

}
