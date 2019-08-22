package com.salvarmaisvidas.collaboratorevents;

import java.io.Serializable;

public class CollaboratorEventId implements Serializable {
    private int collaborator_id;
    private int event_id;

    public CollaboratorEventId(){
    }

    public CollaboratorEventId(int collaborator_id, int event_id) {
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

    public void setEventId(int event_id) {
        this.event_id = event_id;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CollaboratorEventId ceId = (CollaboratorEventId) obj;

        if (collaborator_id != ceId.collaborator_id || event_id != ceId.event_id) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return collaborator_id + event_id;
    }
}
