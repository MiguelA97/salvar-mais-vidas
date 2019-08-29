package com.salvarmaisvidas.collaboratorevent;

import org.springframework.data.domain.Page;

public interface CollaboratorEventService {

    /**
     * Get all CollaboratorEvent in the database
     *
     * @return list of CollaboratorEvent
     */
    Page<CollaboratorEvent> getAllCollaboratorEvents(int pageSize, int page, CollaboratorEventFilter filter);

    /**
     * Get a specific CollaboratorEvent
     *
     * @return requested CollaboratorEvent
     */
    CollaboratorEvent getCollaboratorEvent(int collaborator_id, int event_id);

    /**
     * Inserts a new CollaboratorEvent in the database
     *
     * @return inserted CollaboratorEvent
     */
    CollaboratorEvent newCollaboratorEvent(CollaboratorEvent newCollaboratorEvent);

    /**
     * Replaces a CollaboratorEvent if it exists, if not inserts the new CollaboratorEvent
     *
     * @return replaced CollaboratorEvent
     */
    CollaboratorEvent replaceCollaboratorEvent(CollaboratorEvent newCollaboratorEvent, int collaborator_id, int event_id);

    /**
     * Deletes the specified CollaboratorEvent from the database
     */
    void deleteCollaboratorEvent(int collaborator_id, int event_id);
}
