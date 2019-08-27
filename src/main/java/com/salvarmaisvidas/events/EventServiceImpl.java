package com.salvarmaisvidas.events;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    public EventServiceImpl(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Override
    public Page<Event> getAllEvents(int size, int page, EventFilter filter) {
        return eventRepository.findAll(EventSpec.filter(filter) ,PageRequest.of(page, size, Sort.by("name")));
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public Event newEvent(Event newEvent) {
        if (eventRepository.findByName(newEvent.getName()) != null){
            throw new DuplicateEventField();
        }
        return eventRepository.save(newEvent);
    }

    @Override
    public Event replaceEvent(Event newEvent, int id) {
        return eventRepository.findById(id).map(event -> {
            if (eventRepository.findByName(newEvent.getName()) != null && !newEvent.getName().equals(event.getName())){
                throw new DuplicateEventField();
            }
            event.setName(newEvent.getName());
            event.setEvent_date(newEvent.getEvent_date());
            event.setCollaborators(newEvent.getCollaborators());
            return eventRepository.save(event);
        }).orElseGet(() -> {
            if (eventRepository.findByName(newEvent.getName()) != null){
                throw new DuplicateEventField();
            }
            newEvent.setId(id);
            return eventRepository.save(newEvent);
        });
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
