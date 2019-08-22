package com.salvarmaisvidas.collaborators;

import com.salvarmaisvidas.exceptions.GeneralException;

public class CollaboratorNotFoundException extends GeneralException {

    public CollaboratorNotFoundException(int id) {
        super("collaborator.not.found", new String[]{Integer.toString(id)});
    }
}
