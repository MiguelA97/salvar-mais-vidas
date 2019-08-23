package com.salvarmaisvidas.collaborators;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorSpec {
    public static Specification<Collaborator> filter(CollaboratorFilter filter){

        return new Specification<Collaborator>() {
            @Override
            public Predicate toPredicate(Root<Collaborator> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();

                if(filter.getCc() != null){
                    predicates.add(cb.equal(root.get("cc"), filter.getCc()));
                }
                if(filter.getName() != null) {
                    String like = "%"+filter.getName()+"%";
                    predicates.add(cb.like(root.get("name"),like));
                }
                if(filter.getRegistrationDate()!=null){
                    predicates.add(cb.equal(root.get("registrationDate"),filter.getRegistrationDate()));
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
