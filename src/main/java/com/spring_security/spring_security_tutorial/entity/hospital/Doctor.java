package com.spring_security.spring_security_tutorial.entity.hospital;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "doctors_table")
public class Doctor {

    @Id
    private String id;
    private String name;
    private String email;
    private String address;
    private String phoneNumber;
    private int age;
    private String qualification;
    private String speciality;
    private String hospitalId;

    @OneToMany(mappedBy = "doctor",cascade = CascadeType.ALL)
    private List<Patient>patients;


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Doctor{id='").append(id).append('\'')
          .append(", name='").append(name).append('\'')
          .append(", email='").append(email).append('\'')
          .append(", address='").append(address).append('\'')
          .append(", phoneNumber='").append(phoneNumber).append('\'')
          .append(", age=").append(age)
          .append(", qualification='").append(qualification).append('\'')
          .append(", speciality='").append(speciality).append('\'')
          .append(", hospitalId='").append(hospitalId).append('\'')
          .append(", numberOfPatients=").append(patients != null ? patients.size() : 0)
          .append('}');
        return sb.toString();
    }
}
