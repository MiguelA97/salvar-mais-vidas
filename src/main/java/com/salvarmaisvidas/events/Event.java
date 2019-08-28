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
    private LocalDate eventDate;
    @ManyToMany(mappedBy = "events")
    @JsonBackReference
    private List<Collaborator> collaborators = new ArrayList<>();

    public Event(){
    }

    public Event(String name, LocalDate eventDate) {
        this.name = name;
        this.eventDate = eventDate;
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

    public LocalDate getEventDate() {
        return eventDate;
    }

    public void setEventDate(LocalDate eventDate) {
        this.eventDate = eventDate;
    }

    public List<Collaborator> getCollaborators() {
        return collaborators;
    }

    public void setCollaborators(List<Collaborator> collaborators) {
        this.collaborators = collaborators;
    }
}
