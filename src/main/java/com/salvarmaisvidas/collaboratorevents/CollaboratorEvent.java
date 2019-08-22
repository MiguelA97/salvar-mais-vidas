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

    public int getCollaboratorId() {
        return collaborator_id;
    }

    public void setCollaboratorId(int collaborator_id) {
        this.collaborator_id = collaborator_id;
    }

    public int getEventId() {
        return event_id;
    }

    public void setEventid(int event_id) {
        this.event_id = event_id;
    }
}
