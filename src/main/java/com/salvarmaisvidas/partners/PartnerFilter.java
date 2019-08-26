package com.salvarmaisvidas.partners;

public class PartnerFilter {
    private String name;
    private String cc;
    private int nif;
    private boolean trainer;
    private boolean status;
    private boolean isPrivate;
    private boolean collaborator;
    private boolean sub23;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public int getNif() {
        return nif;
    }

    public void setNif(int nif) {
        this.nif = nif;
    }

    public boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(boolean trainer) {
        this.trainer = trainer;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public boolean isCollaborator() {
        return collaborator;
    }

    public void setCollaborator(boolean collaborator) {
        this.collaborator = collaborator;
    }

    public boolean isSub23() {
        return sub23;
    }

    public void setSub23(boolean sub23) {
        this.sub23 = sub23;
    }
}
