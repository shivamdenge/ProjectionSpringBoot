package com.shivamdenge.Projection;

import com.shivamdenge.Projection.dto.BloodGroupStats;
import com.shivamdenge.Projection.dto.CPatientInfo;
import com.shivamdenge.Projection.dto.IPatientInfo;
import com.shivamdenge.Projection.entity.PatientEntity;
import com.shivamdenge.Projection.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class PatientServiceTest {

    @Autowired
    private PatientRepository patientRepository;

    //Project using Interface & Using this we can not modify data
    @Test
    public void testPatient() {
        // List<PatientEntity> patientEntities = patientRepository.findAll();

        List<IPatientInfo> patientEntities = patientRepository.getAllPatientInfo();

        for (IPatientInfo p : patientEntities) {
            System.out.println("ID: " + p.getId() + ", Name: " + p.getName() + ", Email: " + p.getEmail());
        }

    }


    //Project Using Concrete Class & Using this we can modify data
    @Test
    public void testPatient2() {
        List<CPatientInfo> patientInfos = patientRepository.getAllPatientInfoConcrete();
        for (CPatientInfo c : patientInfos) {
            System.out.println(c);
        }
    }

    @Test
    public void testPatient3() {
        List<BloodGroupStats> patientInfos = patientRepository.getBloodGroupStats();
        for (BloodGroupStats b : patientInfos) {
            System.out.println(b);
        }
    }

    @Test
    public void testPatientUpdateQuery() {
        int rowAffected = patientRepository.updatePatientNameWithId("Shivam Denge", 1L);
        System.out.println("Rows Affected :" + rowAffected);
    }
}
