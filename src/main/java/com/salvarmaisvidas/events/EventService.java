package com.salvarmaisvidas.events;

import com.salvarmaisvidas.collaborators.Collaborator;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EventService {

    /**
     * Get all event in the database
     *
     * @return list of event
     */
    Page<Event> getAllEvents(int size, int page);

    /**
     * Get a specific event
     *
     * @return requested event
     */
    Event getEvent(int id);

    /**
     * Inserts a new event in the database
     *
     * @return inserted event
     */
    Event newEvent(Event newEvent);

    /**
     * Replaces a event if it exists, if not inserts the new event
     *
     * @return replaced event
     */
    Event replaceEvent(Event newEvent, int id);

    /**
     * Deletes the specified event from the database
     */
    void deleteEvent(int id);
}
