package br.com.homework.bill.cloudmedicalappointment.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.homework.bill.cloudmedicalappointment.model.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment,String> {

}
