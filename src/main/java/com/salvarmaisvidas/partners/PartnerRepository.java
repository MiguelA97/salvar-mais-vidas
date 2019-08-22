package com.salvarmaisvidas.partners;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PartnerRepository extends JpaRepository<Partner, Integer>, PagingAndSortingRepository<Partner, Integer> {
}
