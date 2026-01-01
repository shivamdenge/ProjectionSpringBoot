package com.shivamdenge.Projection.repository;

import com.shivamdenge.Projection.entity.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}