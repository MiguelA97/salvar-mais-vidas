package com.salvarmaisvidas.annotations.collaborator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueCollabEmailValidator.class })
public @interface UniqueCollabEmail {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
