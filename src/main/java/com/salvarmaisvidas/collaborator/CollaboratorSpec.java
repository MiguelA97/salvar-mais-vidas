package com.salvarmaisvidas.collaborator;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CollaboratorSpec {
    public static Specification<Collaborator> filter(CollaboratorFilter filter){

        return new Specification<Collaborator>() {
            @Override
            public Predicate toPredicate(Root<Collaborator> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                List<Predicate> orPredicates = new ArrayList<>();

                String search = filter.getSearch();

                if(search != null && !search.isEmpty()){
                    String like = "%" + search + "%";
                    orPredicates.add(cb.like(root.get("name"), like));
                    orPredicates.add(cb.like(root.get("cc"), like));
                    //SO PODEM SER CAMPOS DO TIPO STRING SENAO DA ERRO!

                    predicates.add(cb.or(orPredicates.toArray(new Predicate[0])));
                }

                if(filter.getCc() != null){
                    predicates.add(cb.equal(root.get("cc"), filter.getCc()));
                }
                if(filter.getName() != null) {
                    String like = "%" + filter.getName() + "%";
                    predicates.add(cb.like(root.get("name"), like));
                }
                if(filter.getRegistrationDate() != null){
                    predicates.add(cb.equal(root.get("registrationDate"), filter.getRegistrationDate()));
                }
                if (filter.isTrainer() != null){
                    predicates.add(cb.equal(root.get("trainer"), filter.isTrainer()));
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
