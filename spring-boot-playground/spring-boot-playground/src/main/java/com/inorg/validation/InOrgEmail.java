package com.inorg.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = InOrgEmailValidator.class)
public @interface InOrgEmail {
    String message() default "Invalid email, your email should be of inorg.com domain";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}


