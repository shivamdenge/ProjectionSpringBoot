package com.shivamdenge.Projection;

import com.shivamdenge.Projection.entity.Insurance;
import com.shivamdenge.Projection.service.InsuranceService;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;

@SpringBootTest
public class InsuranceTest {

    @Autowired
    private InsuranceService insuranceService;

    @Test
    public void createNewInsurance(){
        Insurance insurance = Insurance.builder()
                .provider("ICICI Bank")
                .policyNumber("202305636")
                .validUntil(LocalDate.of(2027,12,31))
                .build();

        insuranceService.createNewInsurance(insurance,1L);
    }
}
