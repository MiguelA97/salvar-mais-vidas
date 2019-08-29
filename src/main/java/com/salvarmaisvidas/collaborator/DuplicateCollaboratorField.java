package com.salvarmaisvidas.collaborator;

import com.salvarmaisvidas.exception.GeneralException;

public class DuplicateCollaboratorField extends GeneralException {
    public DuplicateCollaboratorField() {
        super("collaborator.duplicate.fields");
    }
}
