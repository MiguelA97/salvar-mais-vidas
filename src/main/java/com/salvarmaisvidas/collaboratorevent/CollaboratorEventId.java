package com.salvarmaisvidas.collaboratorevent;

import java.io.Serializable;
import java.util.Objects;

public class CollaboratorEventId implements Serializable {
    private int collaborator;
    private int event;

    public CollaboratorEventId(){
    }

    public CollaboratorEventId(int collaborator, int event) {
        this.collaborator = collaborator;
        this.event = event;
    }

    public int getCollaborator() {
        return collaborator;
    }

    public void setCollaborator(int collaborator) {
        this.collaborator = collaborator;
    }

    public int getEvent() {
        return event;
    }

    public void setEvent(int event) {
        this.event = event;
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        CollaboratorEventId ceId = (CollaboratorEventId) obj;

        if (collaborator != ceId.collaborator || event != ceId.event) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return Objects.hash(collaborator, event);
    }
}
