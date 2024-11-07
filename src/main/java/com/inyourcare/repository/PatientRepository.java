package com.inyourcare.repository;

import com.inyourcare.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Long> {
    
    // Find patients by medical condition (assuming you have a "medicalCondition" field)
    List<Patient> findByMedicalCondition(String medicalCondition);

    // Find patients by their sex (if you have a "sex" field)
    List<Patient> findBySex(String sex);

    // Find patients by their age (assuming you have an "age" field)
    List<Patient> findByAge(int age);

    @Query("SELECT p FROM Patient p WHERE p.userId = :userId")
    List<Patient> findByUserId(@Param("userId") Long userId);
}

