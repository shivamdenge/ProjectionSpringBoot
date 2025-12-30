package com.shivamdenge.Projection.repository;

import com.shivamdenge.Projection.dto.BloodGroupStats;
import com.shivamdenge.Projection.dto.CPatientInfo;
import com.shivamdenge.Projection.dto.IPatientInfo;
import com.shivamdenge.Projection.entity.PatientEntity;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.beans.Transient;
import java.util.List;

@Repository
public interface PatientRepository extends JpaRepository<PatientEntity, Long> {

    @Query(value = "select p.id as id, p.name as name, p.email as email from PatientEntity p")
    List<IPatientInfo> getAllPatientInfo();

    @Query("select new com.shivamdenge.Projection.dto.CPatientInfo (p.id, p.name)" + " from PatientEntity p")
    List<CPatientInfo> getAllPatientInfoConcrete();

    @Query("""
                select new com.shivamdenge.Projection.dto.BloodGroupStats(
                    p.bloodGroupType,
                    COUNT(p)
                )
                from PatientEntity p
                group by p.bloodGroupType
                order by COUNT(p)
            """)
    List<BloodGroupStats> getBloodGroupStats();

    @Modifying
    @Transactional
    @Query("UPDATE PatientEntity p set p.name= :name where p.id= :id")
    int updatePatientNameWithId(@Param("name") String name, @Param("id") Long id); //return type int coz it returns numbers of row affected
}
