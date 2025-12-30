package com.shivamdenge.Projection.repository;

import com.shivamdenge.Projection.dto.BloodGroupStats;
import com.shivamdenge.Projection.dto.CPatientInfo;
import com.shivamdenge.Projection.dto.IPatientInfo;
import com.shivamdenge.Projection.entity.Patient;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {

    @Query("Select p.id as id ,p.name as name from Patient p ")
    List<IPatientInfo> getPatientDetails1();

    @Query("""
                select new com.shivamdenge.Projection.dto.CPatientInfo(
                    p.id,
                    p.name,
                    p.email
                )
                from Patient p
            """)
    List<CPatientInfo> getPatientDetails2();

    @Modifying
    @Transactional
    @Query("""
            UPDATE Patient p set p.name= :name where id= :id
            """)
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id);


    @Modifying
    @Transactional
    @Query("""
            DELETE from Patient p where p.id = :id
            """)
    int deletePatientWithId(@Param("id") Long id);


    @Query("""
            select new com.shivamdenge.Projection.dto.BloodGroupStats(
            p.bloodGroupType,
            count(p)
            )
             from Patient p
             Group By (bloodGroupType)
            """)
    List<BloodGroupStats> getBloodGroupStats();
}
