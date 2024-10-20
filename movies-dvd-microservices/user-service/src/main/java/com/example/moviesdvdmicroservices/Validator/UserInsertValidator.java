package com.example.moviesdvdmicroservices.Validator;

import com.example.moviesdvdmicroservices.UserDTO.Credentials;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class UserInsertValidator implements Validator {
    private static final String EMAIL_PATTERN =
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    @Override
    public boolean supports(Class<?> clazz) {
        return Credentials.class == clazz;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Credentials credentials = (Credentials) target;
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"username","empty");
        if(credentials.getUsername().length()< 3 || credentials.getUsername().length() > 50){
            errors.reject("username", "size");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "empty");
        if (!credentials.getEmail().matches(EMAIL_PATTERN)) {
            errors.rejectValue("email", "invalid", "Invalid email format.");
        }
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","empty");
        if(credentials.getPassword().length()< 3 || credentials.getPassword().length() > 500){
            errors.reject("password", "size");
        }


    }


}
