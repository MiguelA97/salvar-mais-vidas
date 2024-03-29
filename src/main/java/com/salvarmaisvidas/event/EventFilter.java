package com.salvarmaisvidas.event;

import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

public class EventFilter {
    private String name;
    @DateTimeFormat(pattern = "dd-MM-yyyy")
    private LocalDate eventDate;
    private String search;

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

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }
}
