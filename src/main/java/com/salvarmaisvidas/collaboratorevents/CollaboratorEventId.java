package com.salvarmaisvidas.collaboratorevents;

import java.io.Serializable;

public class CollaboratorEventId implements Serializable {
    private int collaboratorId;
    private int eventId;

    public CollaboratorEventId(){
    }

    public CollaboratorEventId(int collaboratorId, int eventId) {
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

    public void setEventId(int eventId) {
        this.eventId = eventId;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CollaboratorEventId ceId = (CollaboratorEventId) obj;

        if (collaboratorId != ceId.collaboratorId || eventId != ceId.eventId) return false;
        return true;
    }

    @Override
    public int hashCode(){
        return collaboratorId + eventId;
    }
}
