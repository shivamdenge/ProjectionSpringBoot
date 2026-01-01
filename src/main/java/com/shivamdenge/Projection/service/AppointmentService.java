package com.shivamdenge.Projection.service;

import com.shivamdenge.Projection.entity.Appointment;
import com.shivamdenge.Projection.entity.Doctor;
import com.shivamdenge.Projection.entity.Patient;
import com.shivamdenge.Projection.repository.AppointmentRepository;
import com.shivamdenge.Projection.repository.DoctorRepository;
import com.shivamdenge.Projection.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.print.Doc;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment ,Long patientId, Long doctorId){
        Patient patient = patientRepository.findById(patientId).orElseThrow();
        Doctor doctor = doctorRepository.findById(doctorId).orElseThrow();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        appointmentRepository.save(appointment);
        return appointment;
    }
}
