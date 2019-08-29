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
