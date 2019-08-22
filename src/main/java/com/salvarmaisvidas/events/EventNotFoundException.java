package com.salvarmaisvidas.events;

import com.salvarmaisvidas.exceptions.GeneralException;

public class EventNotFoundException extends GeneralException {
    public EventNotFoundException(int id) {
        super("event.not.found", new String[]{Integer.toString(id)});
    }
}
