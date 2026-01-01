package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Doctor;
import com.shivamdenge.Projection.repository.DoctorRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class DoctorService {

    private final DoctorRepository doctorRepository;

    @Transactional
    public Doctor createNewDoctor(Doctor doctor){
        return doctorRepository.save(doctor);
    }
}
