package com.salvarmaisvidas.collaborators;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer>, PagingAndSortingRepository<Collaborator, Integer> {
}
