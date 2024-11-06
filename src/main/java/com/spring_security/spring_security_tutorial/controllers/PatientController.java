package com.spring_security.spring_security_tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_security.spring_security_tutorial.entity.hospital.Patient;
import com.spring_security.spring_security_tutorial.forms.PatientForm;
import com.spring_security.spring_security_tutorial.service.PatientService;

@Controller
@RequestMapping("/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;


    @GetMapping("/add-patient")
    @ResponseBody
    public String addPatientPage(Model model){

        PatientForm form=new PatientForm();
        model.addAttribute("patientForm", form);
        return "Patient page loading..";
    }

    @PostMapping("/add-patient")
    @ResponseBody
    public String addPatient(@ModelAttribute PatientForm patientForm){

        System.out.println("Inside Patient Form...");
        System.out.println(patientForm.toString());

        Patient newPatient=new Patient();
        newPatient.setName(patientForm.getPatientName());
        newPatient.setEmail(patientForm.getPatientEmail());
        newPatient.setAddress(patientForm.getPatientAddress());
        newPatient.setAge(patientForm.getPatientAge());
        newPatient.setType(patientForm.getPatientType());
        newPatient.setPhoneNumber(patientForm.getPatientPhoneNumber());
        newPatient.setHealthStatus(patientForm.isHealthStatus());

        Patient p = patientService.addPatient(newPatient);
        System.out.println(p.toString());
        return "patient addedd Successfully...";
    }
}
