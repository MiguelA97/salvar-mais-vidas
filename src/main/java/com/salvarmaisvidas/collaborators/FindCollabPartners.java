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

    public int getPartnerId() {
        return partner_id;
    }

    public void setPartnerId(int partner_id) {
        this.partner_id = partner_id;
    }

    public int getCollaboratorId() {
        return collaborator_id;
    }

    public void setCollaboratorId(int collaborator_id) {
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
