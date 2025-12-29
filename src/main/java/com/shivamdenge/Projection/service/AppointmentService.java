package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Appointment;
import com.shivamdenge.Projection.entity.Doctor;
import com.shivamdenge.Projection.entity.PatientEntity;
import com.shivamdenge.Projection.repository.AppointmentRepository;
import com.shivamdenge.Projection.repository.DoctorRepository;
import com.shivamdenge.Projection.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final PatientRepository patientRepository;
    private final DoctorRepository doctorRepository;

    @Transactional
    public Appointment createANewAppointment(Appointment appointment, Long patientId, Long doctorId) {
        PatientEntity patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(patientId).orElseThrow();

        appointment.setPatient(patient);
        appointment.setDoctor(doctor);

        appointmentRepository.save(appointment);

        return appointment;
    }
}
