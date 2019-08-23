package com.salvarmaisvidas.collaborators;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer>, PagingAndSortingRepository<Collaborator, Integer>, JpaSpecificationExecutor<Collaborator> {
    List<Collaborator> findByName(String name);

    Collaborator findByCc(int cc);

    List<Collaborator> findByTrainer(boolean trainer);

    @Query(value = "SELECT NEW com.salvarmaisvidas.collaborators.FindCollabPartners(p.id, c.id, p.name, p.cc) from Partner as p inner join Collaborator as c on p.cc = c.cc")
    List<FindCollabPartners> findCollabPartners();
}
