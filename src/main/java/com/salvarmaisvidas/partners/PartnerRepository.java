package com.salvarmaisvidas.partners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartnerRepository extends JpaRepository<Partner, Integer>, PagingAndSortingRepository<Partner, Integer>, JpaSpecificationExecutor<Partner> {
    Partner findByEmail(String email);
    Partner findByCc(String cc);
    Partner findByNif(int nif);
    Partner findByPhone(int phone);
}
