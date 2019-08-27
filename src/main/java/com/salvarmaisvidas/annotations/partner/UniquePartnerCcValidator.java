package com.salvarmaisvidas.annotations.partner;

import com.salvarmaisvidas.partners.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePartnerCcValidator implements ConstraintValidator<UniquePartnerCc, String> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public void initialize(UniquePartnerCc constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cc, ConstraintValidatorContext context) {
        if (partnerRepository == null) return true;
        return partnerRepository.findByCc(cc) == null;
    }
}
