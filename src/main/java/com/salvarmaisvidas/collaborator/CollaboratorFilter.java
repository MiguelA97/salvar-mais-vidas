package com.salvarmaisvidas.collaborator;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class CollaboratorFilter {
    private String cc;
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;
    private Boolean trainer;

    public CollaboratorFilter() {
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDate registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }
}
