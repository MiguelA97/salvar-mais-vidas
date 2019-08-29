package com.salvarmaisvidas.collaborator;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface CollaboratorRepository extends JpaRepository<Collaborator, Integer>, PagingAndSortingRepository<Collaborator, Integer>, JpaSpecificationExecutor<Collaborator> {

    Collaborator findByEmail(String email);
    Collaborator findByCc(String cc);
    Collaborator findByPhone(int phone);

    @Query(value = "SELECT NEW com.salvarmaisvidas.collaborator.FindCollabPartners(p.id, c.id, p.name, p.cc) from Partner as p inner join Collaborator as c on p.cc = c.cc")
    Page<FindCollabPartners> findCollabPartners(PageRequest pageRequest);
}
