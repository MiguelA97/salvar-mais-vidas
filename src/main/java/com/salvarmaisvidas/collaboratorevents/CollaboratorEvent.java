package com.salvarmaisvidas.collaboratorevents;

import com.salvarmaisvidas.collaborators.Collaborator;
import com.salvarmaisvidas.events.Event;

import javax.persistence.*;

@Entity
@IdClass(CollaboratorEventId.class)
@Table(name = "Collaborator_Event")
public class CollaboratorEvent {

    @Id
    @ManyToOne
    private Collaborator collaborator;

    @Id
    @ManyToOne
    private Event event;

    public CollaboratorEvent(){
    }

    public Collaborator getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(Collaborator collaborator) {
        this.collaborator = collaborator;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public int getCollaborator_id(){
        return collaborator.getId();
    }

    public void setCollaborator_id(int collaborator_id) {
        this.collaborator.setId(collaborator_id);
    }

    public int getEvent_id(){
        return event.getId();
    }

    public void setEvent_id(int event_id){
        this.event.setId(event_id);
    }
}
