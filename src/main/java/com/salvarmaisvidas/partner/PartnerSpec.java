package com.salvarmaisvidas.partner;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class PartnerSpec {
    public static Specification<Partner> filter(PartnerFilter filter){

        return new Specification<Partner>() {
            @Override
            public Predicate toPredicate(Root<Partner> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
                List<Predicate> predicates = new ArrayList<>();
                List<Predicate> orPredicates = new ArrayList<>();

                String search = filter.getSearch();

                if(search != null && !search.isEmpty()){
                    String like = "%" + search + "%";
                    orPredicates.add(cb.like(root.get("name"), like));
                    orPredicates.add(cb.like(root.get("cc"), like));
                    orPredicates.add(cb.like(root.get("partnerType"), like));
                    //SO PODEM SER CAMPOS DO TIPO STRING SENAO DA ERRO!

                    predicates.add(cb.or(orPredicates.toArray(new Predicate[0])));
                }
                if (filter.getName() != null){
                    String like = "%" + filter.getName() + "%";
                    predicates.add(cb.like(root.get("name"), like));
                }
                if (filter.getCc() != null){
                    predicates.add(cb.equal(root.get("cc"), filter.getCc()));
                }
                if (filter.getNif() != null){
                    predicates.add(cb.equal(root.get("nif"), filter.getNif()));
                }
                if (filter.isTrainer() != null){
                    predicates.add(cb.equal(root.get("trainer"), filter.isTrainer()));
                }
                if (filter.isStatus() != null){
                    predicates.add(cb.equal(root.get("status"), filter.isStatus()));
                }
                if (filter.getPartnerType() != null){
                    predicates.add(cb.equal(root.get("partnerType"), filter.getPartnerType()));
                }
                if (filter.isCollaborator() != null){
                    predicates.add(cb.equal(root.get("collaborator"), filter.isCollaborator()));
                }
                if (filter.isSub23() != null){
                    predicates.add(cb.equal(root.get("sub23"), filter.isSub23()));
                }
                return cb.and(predicates.toArray(new Predicate[0]));
            }
        };
    }
}
