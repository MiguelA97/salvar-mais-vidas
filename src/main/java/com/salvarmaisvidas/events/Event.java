package com.salvarmaisvidas.events;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.salvarmaisvidas.collaborators.Collaborator;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private LocalDate event_date;
    @ManyToMany(mappedBy = "events")
    @JsonBackReference
    private List<Collaborator> collaborators = new ArrayList<>();

    public Event(){
    }

    public Event(String name, LocalDate event_date) {
        this.name = name;
        this.event_date = event_date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getEvent_date() {
        return event_date;
    }

    public void setEvent_date(LocalDate event_date) {
        this.event_date = event_date;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }
}
