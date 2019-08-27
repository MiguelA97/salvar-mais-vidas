package com.salvarmaisvidas.collaborators;

import com.salvarmaisvidas.exceptions.GeneralException;

public class DuplicateCollaboratorField extends GeneralException {
    public DuplicateCollaboratorField() {
        super("collaborator.duplicate.fields");
    }
}
