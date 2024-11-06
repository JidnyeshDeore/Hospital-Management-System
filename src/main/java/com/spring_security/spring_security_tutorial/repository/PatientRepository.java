package com.spring_security.spring_security_tutorial.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring_security.spring_security_tutorial.entity.hospital.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, String>{
    
}
