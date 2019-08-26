package com.salvarmaisvidas.events;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class EventFilter {
    private String name;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate eventDate;

    public EventFilter() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }
}
