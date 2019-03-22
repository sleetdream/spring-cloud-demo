package com.example.validator;

import com.example.consts.ValidatorConsts;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER,ElementType.ANNOTATION_TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = PwdValidator.class)
@Documented
public @interface PwdCheck {

    String message() default ValidatorConsts.ILLGAL_PWD;

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
} 