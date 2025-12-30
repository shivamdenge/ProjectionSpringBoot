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
        for (IPatientInfo p : patientInfos) {
            System.out.println(
                    "Id :" + p.getId() +
                            " Name :" + p.getName() +
                            " Email :" + p.getEmail());
        }
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
        List<BloodGroupStats> bloodGroupStats = patientRepository.getBloodGroupStats();
        for (BloodGroupStats b : bloodGroupStats) {
            System.out.println(b);
        }
    }

    @Test
    public void testPatient4() {
        int updatedRow = patientRepository.updatePatientNameWithId("Shivam Denge", 1L);
        System.out.println("Rows Affected :" + updatedRow);
    }

    @Test
    public void testPatient5() {
        int updatedRow = patientRepository.deletePatientWithId(1L);
        System.out.println("Rows Affected :" + updatedRow);
    }
}
