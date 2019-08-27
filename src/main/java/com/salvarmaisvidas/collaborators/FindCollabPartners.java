package com.salvarmaisvidas.collaborators;

public class FindCollabPartners {
    private int partner_id;
    private int collaborator_id;
    private String name;
    private String cc;

    public FindCollabPartners(int partner_id, int collaborator_id, String name, String cc) {
        this.partner_id = partner_id;
        this.collaborator_id = collaborator_id;
        this.name = name;
        this.cc = cc;
    }

    public int getPartner_id() {
        return partner_id;
    }

    public void setPartner_id(int partner_id) {
        this.partner_id = partner_id;
    }

    public int getCollaborator_id() {
        return collaborator_id;
    }

    public void setCollaborator_id(int collaborator_id) {
        this.collaborator_id = collaborator_id;
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
}
