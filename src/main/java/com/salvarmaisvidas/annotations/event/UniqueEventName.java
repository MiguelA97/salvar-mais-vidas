package com.salvarmaisvidas.annotations.event;

import com.salvarmaisvidas.annotations.collaborator.UniqueCollabCcValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueEventNameValidator.class })
public @interface UniqueEventName {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
