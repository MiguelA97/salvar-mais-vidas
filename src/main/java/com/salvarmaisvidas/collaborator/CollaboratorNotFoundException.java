package com.salvarmaisvidas.collaborator;

import com.salvarmaisvidas.exception.GeneralException;

public class CollaboratorNotFoundException extends GeneralException {
    public CollaboratorNotFoundException(int id) {
        super("collaborator.not.found", new String[]{Integer.toString(id)});
    }
}
