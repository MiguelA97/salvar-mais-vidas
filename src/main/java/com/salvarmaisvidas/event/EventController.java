package com.salvarmaisvidas.event;

import com.salvarmaisvidas.util.PageWrapper;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/events")
public class EventController {

    private final EventService eventService;

    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping
    PageWrapper<Event> getAllEvents(@RequestParam(defaultValue = "15") int pageSize, @RequestParam(defaultValue = "0") int page, EventFilter filter, @RequestParam(defaultValue = "id") String sort, @RequestParam(defaultValue = "DESC") String dir){
        return new PageWrapper<>(eventService.getAllEvents(pageSize, page, filter, sort, dir));
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
