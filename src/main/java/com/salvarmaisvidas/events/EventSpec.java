package com.salvarmaisvidas.events;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class EventSpec {
    public static Specification<Event> filter(EventFilter filter){

        return new Specification<Event>() {
            @Override
            public Predicate toPredicate(Root<Event> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (filter.getName() != null){
                    String like = "%" + filter.getName() + "%";
                    predicates.add(cb.like(root.get("name"), like));
                }
                if(filter.getEventDate() != null){
                    predicates.add(cb.equal(root.get("eventDate"), filter.getEventDate()));
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
