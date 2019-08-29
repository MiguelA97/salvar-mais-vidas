package com.salvarmaisvidas.event;

import com.salvarmaisvidas.exception.GeneralException;

public class EventNotFoundException extends GeneralException {
    public EventNotFoundException(int id) {
        super("event.not.found", new String[]{Integer.toString(id)});
    }
}
