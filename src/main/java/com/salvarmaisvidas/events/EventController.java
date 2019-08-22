package com.salvarmaisvidas.events;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    List<Event> getAllEvents(){
        return eventService.getAllEvents();
    }

    @GetMapping("/{id}")
    Event getEvent(@PathVariable int id){
        return eventService.getEvent(id);
    }

    @PostMapping
    Event newEvent(@RequestBody Event newEvent){
        return eventService.newEvent(newEvent);
    }

    @PutMapping("/{id}")
    Event replaceEvent(@RequestBody Event newEvent, @PathVariable int id){
        return eventService.replaceEvent(newEvent, id);
    }

    @DeleteMapping("/{id}")
    void deleteEvent(@PathVariable int id){
        eventService.deleteEvent(id);
    }
}
