package com.example.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PwdValidator implements ConstraintValidator<PwdCheck,String> {
    private String regExp = "^(?=.*[a-zA-Z0-9].*)(?=.*[a-zA-Z\\W].*)(?=.*[0-9\\W].*).{8,20}$";

    public void initialize(PwdCheck pwdCheck) {

    }

    public boolean isValid(String str, ConstraintValidatorContext constraintValidatorContext) {
        if (str == null) {
            return true;
        }
        Pattern p = Pattern.compile(regExp);
        Matcher m = p.matcher(str);
        return m.matches();
    }
} 