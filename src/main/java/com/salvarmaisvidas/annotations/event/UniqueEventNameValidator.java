package com.salvarmaisvidas.annotations.event;

import com.salvarmaisvidas.events.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class UniqueEventNameValidator implements ConstraintValidator<UniqueEventName, String> {

    @Autowired
    private EventRepository eventRepository;

    @Override
    public void initialize(UniqueEventName constraintAnnotation) {
    }

    @Override
    public boolean isValid(String name, ConstraintValidatorContext context) {
        if (eventRepository == null) return true;
        return eventRepository.findByName(name) == null;
    }
}
