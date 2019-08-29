package com.salvarmaisvidas.collaboratorevent;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorEventSpec {
    public static Specification<CollaboratorEvent> filter(CollaboratorEventFilter filter){

        return new Specification<CollaboratorEvent>() {
            @Override
            public Predicate toPredicate(Root<CollaboratorEvent> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if (filter.getCollaboratorId() != null){
                    predicates.add(cb.equal(root.get("collaborator_id"), filter.getCollaboratorId()));
                }
                if (filter.getEventId() != null){
                    predicates.add(cb.equal(root.get("event_id"), filter.getEventId()));
                }

                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
