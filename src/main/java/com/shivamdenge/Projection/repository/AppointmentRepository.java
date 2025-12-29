package com.shivamdenge.Projection.repository;

import com.shivamdenge.Projection.entity.Appointment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> {
}