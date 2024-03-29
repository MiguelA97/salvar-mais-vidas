package com.salvarmaisvidas.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface EventRepository extends JpaRepository<Event, Integer>, PagingAndSortingRepository<Event, Integer>, JpaSpecificationExecutor<Event> {
    Event findByName(String name);
}
