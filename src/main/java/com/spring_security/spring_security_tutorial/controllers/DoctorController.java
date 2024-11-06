package com.spring_security.spring_security_tutorial.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring_security.spring_security_tutorial.entity.hospital.Doctor;
import com.spring_security.spring_security_tutorial.forms.DoctorForm;
import com.spring_security.spring_security_tutorial.service.DoctorService;

import jakarta.validation.Valid;


/*@RestController:
    Combines @Controller and @ResponseBody.
    Automatically serializes responses to JSON or XML.
    Ideal for RESTful APIs.

@Controller:
    Used for traditional MVC applications.
    Returns view names instead of raw data.
    Requires additional handling to return JSON, typically using @ResponseBody.

Cause of Internal Server Error:
    When switching from @RestController to @Controller, your addDoctor method returns a string that Spring expects to be a view name. 
    Since there's no corresponding view template (like a JSP or Thymeleaf page) for "Doctor Added Successfully," 
    Spring fails to resolve it, resulting in a 500 Internal Server Error

Summary:
    Use @RestController for APIs to return data directly. 
    Use @Controller for MVC applications where you need to render views. 
    If using @Controller, ensure the return values correspond to valid view templates
*/
@Controller                                                                         
@RequestMapping("/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;



    /*
        If you want to return a view from a method, do not use @ResponseBody for that method.
        Keep @ResponseBody on methods where you want to return data directly (like JSON or plain text).
        For methods that return view names, simply return the view name as a string without @ResponseBody. 
     
     */
    @GetMapping("/add-doctor")
    @ResponseBody
    public String addDoctorForm(Model model){

        DoctorForm form=new DoctorForm();
        model.addAttribute("doctorForm", form);
        return "Doctor Page Loading";
    }

    @PostMapping("/add-doctor")
    @ResponseBody
    public String addDoctor(@Valid @ModelAttribute DoctorForm oldDoctorForm,BindingResult result){

        if(result.hasErrors()){
            System.out.println("Inside Doctor Post Mapping...Error Occured.....");
            return "error occured";
        }
        System.out.println("Inside Doctor Post Mapping...");
        System.out.println(oldDoctorForm.toString());
        Doctor newDoctor=new Doctor();
        newDoctor.setName(oldDoctorForm.getDoctorName());
        newDoctor.setEmail(oldDoctorForm.getDoctorEmail());
        newDoctor.setAddress(oldDoctorForm.getDoctorAddress());
        newDoctor.setPhoneNumber(oldDoctorForm.getDoctorPhoneNumber());
        newDoctor.setAge(oldDoctorForm.getDoctorAge());
        newDoctor.setSpeciality(oldDoctorForm.getDoctorSpeciality().toLowerCase());
        newDoctor.setQualification(oldDoctorForm.getDoctorQualification().toUpperCase());

        Doctor d = doctorService.addDoctor(newDoctor);
        System.out.println(d.toString());
        
        return "Doctort Addedd Successfully";
    }
}
