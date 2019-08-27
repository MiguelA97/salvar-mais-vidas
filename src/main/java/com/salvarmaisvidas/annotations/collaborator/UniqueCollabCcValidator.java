package com.salvarmaisvidas.annotations.collaborator;

import com.salvarmaisvidas.annotations.collaborator.UniqueCollabCc;
import com.salvarmaisvidas.collaborators.CollaboratorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueCollabCcValidator implements ConstraintValidator<UniqueCollabCc, String> {

    @Autowired
    private CollaboratorRepository collaboratorRepository;

    @Override
    public void initialize(UniqueCollabCc constraintAnnotation) {
    }

    @Override
    public boolean isValid(String cc, ConstraintValidatorContext context) {
        if (collaboratorRepository == null) return true;
        return collaboratorRepository.findByCc(cc) == null;
    }
}
