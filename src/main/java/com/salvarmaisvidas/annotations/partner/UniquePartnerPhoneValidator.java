package com.salvarmaisvidas.annotations.partner;

import com.salvarmaisvidas.partners.PartnerRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniquePartnerPhoneValidator implements ConstraintValidator<UniquePartnerPhone, Integer> {

    @Autowired
    private PartnerRepository partnerRepository;

    @Override
    public void initialize(UniquePartnerPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer phone, ConstraintValidatorContext context) {
        if (partnerRepository == null) return true;
        return partnerRepository.findByPhone(phone) == null;
    }
}
