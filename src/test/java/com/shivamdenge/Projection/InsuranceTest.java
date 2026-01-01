package com.shivamdenge.Projection;

import com.shivamdenge.Projection.entity.Appointment;
import com.shivamdenge.Projection.entity.Insurance;
import com.shivamdenge.Projection.service.AppointmentService;
import com.shivamdenge.Projection.service.InsuranceService;
import com.shivamdenge.Projection.service.PatientService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private PatientService patientService;

    @Autowired
    private InsuranceService insuranceService;

    @Autowired
    private AppointmentService appointmentService;

    @Test
    public void testAssignInsuranceToPatient() {
        Insurance insurance = Insurance.builder()
                .provider("ICICI Bank")
                .policyNumber("ICICI_23G")
                .validUntil(LocalDate.of(2030, 1, 1))
                .build();

        var updatedInsurance = insuranceService.assignInsuranceToPatient(insurance, 1L);

        System.out.println(updatedInsurance);

        patientService.deletePatient(1L);
    }

    @Test
    public void testCreateAppointment() {
        Appointment appointment = Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025, 12, 1, 14, 0, 0))
                .reason("Cancer")
                .build();

        var updatedAppointment = appointmentService.createANewAppointment(appointment, 3L, 2L);
        System.out.println(updatedAppointment);

        patientService.deletePatient(3L);
    }
}
