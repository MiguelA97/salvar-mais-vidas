package com.salvarmaisvidas.collaborators;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Collaborator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;
    private String email;
    private LocalDate birth_date;
    private String cc;
    private String address;
    private String postal_code;
    private String locality;
    private int phone;
    private String job;
    private boolean trainer;
    private LocalDate registration_date;

    public Collaborator(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthDate() {
        return birth_date;
    }

    public void setBirthDate(LocalDate birth_date) {
        this.birth_date = birth_date;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostalCode() {
        return postal_code;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }

    public String getLocality() {
        return locality;
    }

    public void setLocality(String locality) {
        this.locality = locality;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    public LocalDate getRegistrationDate() {
        return registration_date;
    }

    public void setRegistrationDate(LocalDate registration_date) {
        this.registration_date = registration_date;
    }
}
