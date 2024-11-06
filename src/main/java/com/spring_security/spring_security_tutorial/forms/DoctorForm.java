package com.spring_security.spring_security_tutorial.forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class DoctorForm {

    @NotBlank(message = "Name should not be blank")
    private String doctorName;
    @Email
    @NotNull(message = "Email required")
    private String doctorEmail;

    private String doctorAddress;
    @Size(min = 10,max = 10,message = "Size should be of 10")
    private String doctorPhoneNumber;
    private int doctorAge;
    
    private String doctorQualification;
    private String doctorSpeciality;

}
