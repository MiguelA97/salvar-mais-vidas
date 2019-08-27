package com.salvarmaisvidas.annotations.partner;

import com.salvarmaisvidas.partners.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePartnerNifValidator implements ConstraintValidator<UniquePartnerNif, Integer> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public void initialize(UniquePartnerNif constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer nif, ConstraintValidatorContext context) {
        if (partnerRepository == null) return true;
        return partnerRepository.findByNif(nif) == null;
    }
}
