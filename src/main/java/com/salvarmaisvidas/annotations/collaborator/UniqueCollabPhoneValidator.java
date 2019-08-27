package com.salvarmaisvidas.annotations.collaborator;

import com.salvarmaisvidas.collaborators.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCollabPhoneValidator implements ConstraintValidator<UniqueCollabPhone, Integer> {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public void initialize(UniqueCollabPhone constraintAnnotation) {
    }

    @Override
    public boolean isValid(Integer phone, ConstraintValidatorContext context) {
        if (collaboratorRepository == null) return true;
        return collaboratorRepository.findByPhone(phone) == null;
    }
}
