package com.spring_security.spring_security_tutorial.entity.hospital;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "patients_table")
public class Patient {

    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private int age;
    private String phoneNumber;
    private String type;
    private boolean healthStatus;
    private String hospitalId;

    @ManyToOne
    @JoinColumn(name = "doctor_id",nullable = false)
    private Doctor doctor;



    /*
        The StackOverflowError you’re encountering is likely due to a recursive call in the toString() methods of your Doctor and Patient classes. 
        When you attempt to print a Doctor object, it tries to access its list of Patient objects, 
        which in turn calls the toString() method on each Patient. Since each Patient holds a reference back to its Doctor, 
        this creates a cycle that leads to infinite recursion.
        To fix this, you can modify the toString() methods to avoid this cyclic reference. Here's how you can do it 
    */
    @Override
    public String toString() {
        return "Patient{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", type='" + type + '\'' +
                ", healthStatus=" + healthStatus +
                ", hospitalId='" + hospitalId + '\'' +
                ", doctorId='" + (doctor != null ? doctor.getId() : "N/A") + '\'' + // Include doctor ID
                '}';
    }

}
