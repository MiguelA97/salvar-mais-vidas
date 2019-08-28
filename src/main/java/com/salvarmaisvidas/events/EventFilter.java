package com.salvarmaisvidas.events;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EventFilter {
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
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
