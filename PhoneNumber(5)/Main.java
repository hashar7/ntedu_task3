package com.company;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {

        PhoneNumber p1 = new PhoneNumber("+79175655655");
        PhoneNumber p2 = new PhoneNumber("+104289652211");
        PhoneNumber p3 = new PhoneNumber("89175655655");

        System.out.println(p1.toString());
        System.out.println(p2.toString());
        System.out.println(p3.toString());

        /* OUTPUT:
        PhoneNumber{phoneNumber='+7917-565-5655'}
        PhoneNumber{phoneNumber='+10428-965-2211'}
        PhoneNumber{phoneNumber='+7917-565-5655'}
         */

    }
}

