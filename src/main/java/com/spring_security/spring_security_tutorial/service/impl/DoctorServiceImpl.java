package com.spring_security.spring_security_tutorial.service.impl;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security.spring_security_tutorial.entity.hospital.Doctor;
import com.spring_security.spring_security_tutorial.repository.DoctorRepository;
import com.spring_security.spring_security_tutorial.service.DoctorService;

@Service
public class DoctorServiceImpl implements DoctorService{

    @Autowired
    private DoctorRepository doctorRepository;

    @Override
    public Doctor addDoctor(Doctor oldDoctor) {
        

        final String dname="DOCTOR";
        // Doctor doctor=new Doctor();
        String did=UUID.randomUUID().toString().substring(0, 5);
        oldDoctor.setId(did);
        String hid=dname +"_"+oldDoctor.getId()+"_"+oldDoctor.getSpeciality();

        oldDoctor.setHospitalId(hid);
        return doctorRepository.save(oldDoctor);
    }

    
}
