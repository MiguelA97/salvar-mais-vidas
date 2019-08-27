package com.salvarmaisvidas.events;

import com.salvarmaisvidas.exceptions.GeneralException;

public class DuplicateEventField extends GeneralException {
    public DuplicateEventField() {
        super("event.duplicate.fields");
    }
}
