package com.salvarmaisvidas.event;

import com.salvarmaisvidas.exception.GeneralException;

public class DuplicateEventField extends GeneralException {
    public DuplicateEventField() {
        super("event.duplicate.fields");
    }
}
