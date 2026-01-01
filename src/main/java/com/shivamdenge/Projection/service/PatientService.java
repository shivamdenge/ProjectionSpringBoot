package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Patient;
import com.shivamdenge.Projection.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {

    private final PatientRepository patientRepository;

    @Transactional
    public Patient createNewPatient(Patient patient){
        return patientRepository.save(patient);
    }
}
