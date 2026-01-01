package com.shivamdenge.Projection;

import com.shivamdenge.Projection.entity.Appointment;
import com.shivamdenge.Projection.entity.Doctor;
import com.shivamdenge.Projection.repository.AppointmentRepository;
import com.shivamdenge.Projection.repository.DoctorRepository;
import com.shivamdenge.Projection.service.AppointmentService;
import com.shivamdenge.Projection.service.DoctorService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.print.Doc;
import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest{

    @Autowired
    private AppointmentService appointmentService;

    @Autowired
    private DoctorService doctorService;

    @Test
    public void testDoctor(){
        Doctor doctor = Doctor.builder()
                .email("adityaD@aims.in")
                .name("Dr.Aditya Deshmukh")
                .specialization("Neurosurgen")
                .build();

        var update = doctorService.createNewDoctor(doctor);
        System.out.println(update);
    }

    @Test
    public void testAppointment(){
        Appointment appointment = Appointment.builder()
                .reason("Cancer")
                .status("Not Serious")
                .appointmentTime(LocalDateTime.of(2025, 11, 1, 14, 0, 0))
                .build();
        var update = appointmentService.createNewAppointment(appointment,1L,2L);
        System.out.println(update);
    }
}
