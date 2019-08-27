package com.salvarmaisvidas.annotations.partner;

import com.salvarmaisvidas.partners.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePartnerEmailValidator implements ConstraintValidator<UniquePartnerEmail, String> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public void initialize(UniquePartnerEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (partnerRepository == null) return true;
        return partnerRepository.findByEmail(email) == null;
    }
}
