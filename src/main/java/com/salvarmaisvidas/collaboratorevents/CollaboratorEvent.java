package com.salvarmaisvidas.collaboratorevents;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

@Entity
@IdClass(CollaboratorEventId.class)
@Table(name = "Collaborator_Event")
public class CollaboratorEvent {

    @Id
    private int collaboratorId;
    @Id
    private int eventId;

    public CollaboratorEvent(){
    }

    public CollaboratorEvent(int collaboratorId, int eventId) {
        this.collaboratorId = collaboratorId;
        this.eventId = eventId;
    }

    public int getCollaboratorId() {
        return collaboratorId;
    }

    public void setCollaboratorId(int collaboratorId) {
        this.collaboratorId = collaboratorId;
    }

    public int getEventId() {
        return eventId;
    }

    public void setEventid(int eventId) {
        this.eventId = eventId;
    }
}
