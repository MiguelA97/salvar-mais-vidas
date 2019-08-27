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
    private int collaborator_id;
    @Id
    private int event_id;

    public CollaboratorEvent(){
    }

    public CollaboratorEvent(int collaborator_id, int event_id) {
        this.collaborator_id = collaborator_id;
        this.event_id = event_id;
    }

    public int getCollaborator_id() {
        return collaborator_id;
    }

    public void setCollaborator_id(int collaborator_id) {
        this.collaborator_id = collaborator_id;
    }

    public int getEvent_id() {
        return event_id;
    }

    public void setEvent_id(int eventId) {
        this.event_id = eventId;
    }
}
