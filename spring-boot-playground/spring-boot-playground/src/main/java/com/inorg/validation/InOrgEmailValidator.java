package com.inorg.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InOrgEmailValidator implements ConstraintValidator<InOrgEmail,String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
        String regex="^[A-Za-z][A-Za-z0-9_.]+@inorg\\.com";
        Pattern pattern=Pattern.compile(regex);
        Matcher matcher=pattern.matcher(value);
        boolean matches=matcher.matches();
        return matches;
    }
}
