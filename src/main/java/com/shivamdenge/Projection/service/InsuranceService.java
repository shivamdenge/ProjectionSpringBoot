package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Insurance;
import com.shivamdenge.Projection.entity.Patient;
import com.shivamdenge.Projection.repository.InsuranceRepository;
import com.shivamdenge.Projection.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InsuranceService {

    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public void createNewInsurance(Insurance insurance, Long patientId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        insurance.setPatient(patient);
        patient.setInsurance(insurance);

        insuranceRepository.save(insurance);
    }
}
