package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumber {
    private String phoneNumber;

    public PhoneNumber() {
        phoneNumber = null;
    }

    public PhoneNumber(String in) throws IllegalArgumentException {
        Pattern pattern1 = Pattern.compile("^\\+(\\d+)(\\d{3})(\\d{3})(\\d{4})$");
        Pattern pattern2 = Pattern.compile("^(8)(\\d{3})(\\d{3})(\\d{4})$");
        Matcher matcher = pattern1.matcher(in);
        if (!matcher.matches()) {
            matcher = pattern2.matcher(in);
            if (!matcher.matches()) {
                throw new IllegalArgumentException();
            }
        }
        phoneNumber = String.format("+%s%s-%s-%s",
                matcher.group(1).equals("8") ? "7" : matcher.group(1),
                matcher.group(2), matcher.group(3), matcher.group(4));
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}

