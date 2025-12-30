package com.shivamdenge.Projection;

import com.shivamdenge.Projection.dto.BloodGroupStats;
import com.shivamdenge.Projection.dto.CPatientInfo;
import com.shivamdenge.Projection.dto.IPatientInfo;
import com.shivamdenge.Projection.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientTest {

    @Autowired
    private PatientRepository patientRepository;

    @Test
    public void testPatient1() {
        List<IPatientInfo> patientInfos = patientRepository.getPatientDetails1();
        for (IPatientInfo p : patientInfos)
            System.out.println("ID :" + p.getId() + " NAME :" + p.getName());
    }

    @Test
    public void testPatient2() {
        List<CPatientInfo> patientInfos = patientRepository.getPatientDetails2();
        for (CPatientInfo p : patientInfos) {
            System.out.println(p);
        }
    }

    @Test
    public void testPatient3() {
        var updatedRows = patientRepository.updatePatientNameWithId("Shivam Denge", 1L);
        System.out.println("UpdatedRows :" + updatedRows);
    }

    @Test
    public void testPatient4() {
        var updatedRows = patientRepository.deletePatientWithId(1L);
        System.out.println("UpdatedRows :" + updatedRows);
    }

    @Test
    public void testPatient5() {
        List<BloodGroupStats> bloodGroupStats = patientRepository.getBloodGroupStats();
        for (BloodGroupStats b : bloodGroupStats)
            System.out.println(b);
    }
}
