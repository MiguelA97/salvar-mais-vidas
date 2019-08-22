package com.salvarmaisvidas.collaboratorevents;

import com.salvarmaisvidas.exceptions.GeneralException;

public class CollaboratorEventNotFoundException extends GeneralException {
    public CollaboratorEventNotFoundException(int collaborator_id, int event_id) {
        super("collaborator.event.not.found", new String[]{Integer.toString(collaborator_id), Integer.toString(event_id)});
    }
}
