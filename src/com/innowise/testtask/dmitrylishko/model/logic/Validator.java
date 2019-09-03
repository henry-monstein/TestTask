package com.innowise.testtask.dmitrylishko.model.logic;

import java.util.regex.Pattern;

public class Validator {
    public final String EMAIL_PATTERN = "^[A-Za-z0-9+_.-]+@[a-z]+[.][a-z]+$";
    public final String PHONE_PATTERN = "375\\d{2}\\s\\d{7}";
    public final String LINE_PATTERN = "^Name: .+; Surname: .+; Email: [A-Za-z0-9+_.-]+@[a-z]+[.][a-z]+; " +
            "Roles: \\[(.+(, )?){1,3}\\]; Phones: \\[(375\\d{2}\\s\\d{7}(, )?){1,3}\\];$";

    public boolean isEmail(String email) {
        return Pattern.matches(EMAIL_PATTERN, email);
    }

    public boolean isPhone(String phone) {
        return Pattern.matches(PHONE_PATTERN, phone);
    }

    public boolean isPhones(String[] phones) {
        for (String phone: phones) {
            if(!isPhone(phone))
                return false;
        }
        return true;
    }

    public boolean isLineValid(String line) {
        return Pattern.matches(LINE_PATTERN, line);
    }
}
