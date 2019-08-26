package com.salvarmaisvidas.collaborators;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class CollaboratorFilter {
    private String cc;
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate registrationDate;
    private boolean trainer;

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

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }
}
