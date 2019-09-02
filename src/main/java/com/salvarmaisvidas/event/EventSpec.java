package com.salvarmaisvidas.event;

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
                List<Predicate> orPredicates = new ArrayList<>();

                String search = filter.getSearch();

                if(search != null && !search.isEmpty()){
                    String like = "%" + search + "%";
                    orPredicates.add(cb.like(root.get("name"), like));
                    //SO PODEM SER CAMPOS DO TIPO STRING SENAO DA ERRO!

                    predicates.add(cb.or(orPredicates.toArray(new Predicate[0])));
                }

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
