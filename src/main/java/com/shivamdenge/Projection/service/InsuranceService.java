package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Insurance;
import com.shivamdenge.Projection.entity.PatientEntity;
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

    @Transactional //This will ensure that if it excute completely or not at all
    public Insurance assignInsuranceToPatient(Insurance insurance, Long patientId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);  //this establishes relation

        insurance.setPatient(patient); //optional this is for by directional relationship

        return insurance;
    }

    @Transactional
    public Insurance updateInsuranceOfPatient(Insurance insurance,Long patientId){
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(insurance);
        insurance.setPatient(patient);

        return insurance;
    }

    @Transactional
    public PatientEntity removeInsuranceOfPatient(Long patientId){
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();

        patient.setInsurance(null);

        return patient;
    }
}
