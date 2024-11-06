package com.spring_security.spring_security_tutorial.service.impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring_security.spring_security_tutorial.entity.hospital.Doctor;
import com.spring_security.spring_security_tutorial.entity.hospital.Patient;
import com.spring_security.spring_security_tutorial.repository.DoctorRepository;
import com.spring_security.spring_security_tutorial.repository.PatientRepository;
import com.spring_security.spring_security_tutorial.service.PatientService;

@Service
public class PatientServiceImpl implements PatientService{

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private DoctorRepository doctorRepository;


    @Override
    public Patient addPatient(Patient oldPatient) {
       
        final String pname="PATIENT";
        String pid=UUID.randomUUID().toString().substring(0, 5);

        oldPatient.setId(pid);

        String hid=pname+"_"+oldPatient.getId()+"_"+oldPatient.getType();
        oldPatient.setHospitalId(hid);


        String speciality=oldPatient.getType().toLowerCase();
        List<Doctor> list=doctorRepository.findBySpeciality(speciality);
        Doctor doctor=freeDoctor(list);
        oldPatient.setDoctor(doctor);
        return patientRepository.save(oldPatient);
    }

    public Doctor freeDoctor(List<Doctor>list){

        if(list.isEmpty()){
            return null;
        }
        Doctor minDoctor=list.get(0);
        for(Doctor checkDoctor:list){
            if(checkDoctor.getPatients().size()<minDoctor.getPatients().size()){
                minDoctor=checkDoctor;
            }
        }
        return minDoctor;
    }

}
