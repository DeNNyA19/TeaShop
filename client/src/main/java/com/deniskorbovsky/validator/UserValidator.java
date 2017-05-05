package com.deniskorbovsky.validator;

import com.deniskorbovsky.model.User;
import com.deniskorbovsky.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

/**
 * Created by denis on 20.04.2017.
 */
@Component
public class UserValidator implements Validator {

    @Autowired
    private UserService userService;

    @Override
    public boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "username", "username.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "password.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "confirmPassword", "confirmPassword.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "nameReg.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phoneReg.required");
        User user = (User) o;
        if (userService.findByUsername(user.getUsername()) != null) {
            errors.rejectValue("username", "username.exists");
        }
        if (user.getPassword().length() < 4) {
            errors.rejectValue("password", "password.short");
        }
        if (!user.getPassword().equals(user.getConfirmPassword())) {
            errors.rejectValue("confirmPassword", "confirmPassword.notMatch");
        }
        if (!user.getPhone().matches("\\+\\d{12}")) {
            errors.rejectValue("phone", "phone.incorrect");
        }
        if (!user.getEmail().isEmpty() && !user.getEmail().matches(".+@\\w+\\.\\w+")) {
            errors.rejectValue("email", "email.incorrect");
        }
    }
}
