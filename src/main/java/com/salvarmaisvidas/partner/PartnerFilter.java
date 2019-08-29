package com.salvarmaisvidas.partner;

public class PartnerFilter {
    private String name;
    private String cc;
    private Integer nif;
    private Boolean trainer;
    private Boolean status;
    private String partnerType;
    private Boolean collaborator;
    private Boolean sub23;

    public PartnerFilter() {
    }

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

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public Boolean isTrainer() {
        return trainer;
    }

    public void setTrainer(Boolean trainer) {
        this.trainer = trainer;
    }

    public Boolean isStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }

    public String getPartnerType() {
        return partnerType;
    }

    public void setPartnerType(String aPrivate) {
        partnerType = aPrivate;
    }

    public Boolean isCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Boolean collaborator) {
        this.collaborator = collaborator;
    }

    public Boolean isSub23() {
        return sub23;
    }

    public void setSub23(Boolean sub23) {
        this.sub23 = sub23;
    }
}
