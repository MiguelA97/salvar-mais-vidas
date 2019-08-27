package com.salvarmaisvidas.annotations.collaborator;

import com.salvarmaisvidas.annotations.collaborator.UniqueCollabEmail;
import com.salvarmaisvidas.collaborators.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCollabEmailValidator implements ConstraintValidator<UniqueCollabEmail, String> {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public void initialize(UniqueCollabEmail constraintAnnotation) {
    }

    @Override
    public boolean isValid(String email, ConstraintValidatorContext context) {
        if (collaboratorRepository == null) return true;
        return collaboratorRepository.findByEmail(email) == null;
    }
}
