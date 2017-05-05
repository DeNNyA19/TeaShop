package com.deniskorbovsky.validator;

import com.deniskorbovsky.model.Order;
import com.deniskorbovsky.model.User;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class OrderValidator implements Validator {

    public boolean supports(Class<?> aClass) {
        if (User.class.isAssignableFrom(aClass) || Order.class.isAssignableFrom(aClass))
            return true;
        else
            return false;
    }

    public void validate(Object o, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "name.required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "phone.required");
        Order order = (Order) o;
        if (!order.getPhone().isEmpty() && !order.getPhone().matches("\\+\\d{12}")) {
            errors.rejectValue("phone", "phone.incorrect");
        }
        if (!order.getEmail().isEmpty() && !order.getEmail().matches(".+@\\w+\\.\\w+")) {
            errors.rejectValue("email", "email.incorrect");
        }
    }
}
