package com.spring_security.spring_security_tutorial.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class PatientForm {

    @NotBlank(message = "Name required...")
    private String patientName;
    @Email
    @NotBlank(message = "Name required...")
    private String patientEmail;
    private String patientAddress;
    private int patientAge;
    
    @Size(min = 10,max = 10,message = "Size should be of 10")
    private String patientPhoneNumber;
    private String patientType;
    private boolean healthStatus;
}
