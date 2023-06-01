package com.example.CaNhan.validator;

import com.example.CaNhan.entity.Office;
import com.example.CaNhan.validator.annotation.ValidOfficeId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;



public class ValidOfficeIdValidator implements ConstraintValidator<ValidOfficeId, Office> {
    @Override
    public boolean isValid(Office category, ConstraintValidatorContext context ){
        return category != null && category.getMaPhong() != null;
    }
}
