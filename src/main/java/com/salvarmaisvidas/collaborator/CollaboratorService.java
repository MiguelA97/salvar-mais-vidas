package com.salvarmaisvidas.collaborator;

import org.springframework.data.domain.Page;

public interface CollaboratorService {

    /**
     * Get all collaborators in the database
     *
     * @return list of collaborators
     */
    Page<Collaborator> getAllCollaborators(int pageSize, int page, CollaboratorFilter filter, String sort, String dir);

    /**
     * Get a specific collaborator
     *
     * @return requested collaborator
     */
    Collaborator getCollaborator(int id);

    /**
     * Inserts a new collaborator in the database
     *
     * @return inserted collaborator
     */
    Collaborator newCollaborator(Collaborator newCollaborator);

    /**
     * Replaces a collaborator if it exists, if not inserts the new collaborator
     *
     * @return replaced collaborator
     */
    Collaborator replaceCollaborator(Collaborator newCollaborator, int id);

    /**
     * Deletes the specified collaborator from the database
     */
    void deleteCollaborator(int id);
}
