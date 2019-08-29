package com.salvarmaisvidas.event;

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
    public Page<Event> getAllEvents(int pageSize, int page, EventFilter filter, String sort, String dir) {
        return eventRepository.findAll(EventSpec.filter(filter), PageRequest.of(page, pageSize, Sort.Direction.fromString(dir), sort));
    }

    @Override
    public Event getEvent(int id) {
        return eventRepository.findById(id).orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public Event newEvent(Event newEvent) {
        if (eventRepository.findByName(newEvent.getName()) != null)
            throw new DuplicateEventField();
        return eventRepository.save(newEvent);
    }

    @Override
    public Event replaceEvent(Event newEvent, int id) {
        return eventRepository.findById(id).map(event -> {
            if (eventRepository.findByName(newEvent.getName()) != null && !newEvent.getName().equals(event.getName()))
                throw new DuplicateEventField();

            event.setName(newEvent.getName());
            event.setEventDate(newEvent.getEventDate());
            event.setCollaborators(newEvent.getCollaborators());
            return eventRepository.save(event);
        }).orElseThrow(() -> new EventNotFoundException(id));
    }

    @Override
    public void deleteEvent(int id) {
        eventRepository.deleteById(id);
    }
}
