package com.salvarmaisvidas.collaboratorevents;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CollaboratorEventRepository extends JpaRepository<CollaboratorEvent, CollaboratorEventId>, PagingAndSortingRepository<CollaboratorEvent, CollaboratorEventId> {
}
