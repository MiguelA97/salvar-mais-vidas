package com.salvarmaisvidas.events;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public Event newEvent(Event newEvent) {
        return eventRepository.save(newEvent);
    }

    @Override
    public Event replaceEvent(Event newEvent, int id) {
        return eventRepository.findById(id).map(event -> {
            event.setName(newEvent.getName());
            event.setDate(newEvent.getDate());
            return eventRepository.save(event);
        }).orElseGet(() -> {
            newEvent.setId(id);
            return eventRepository.save(newEvent);
        });
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
