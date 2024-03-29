package com.salvarmaisvidas.event;

import org.springframework.data.domain.Page;

public interface EventService {

    /**
     * Get all event in the database
     *
     * @return list of event
     */
    Page<Event> getAllEvents(int pageSize, int page, EventFilter filter, String sort, String dir);

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
