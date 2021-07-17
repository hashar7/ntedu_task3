package com.company;

public class Main {

    public static void main(String[] args) {
        Person p1 = new Person("Ivanov", "Ivan", "Ivanovich");
//        Person p2 = new Person(null, "Ivan", "Ivanovich");
        Person p3 = new Person("Ivanov", null, "Ivanovich");
        Person p4 = new Person("Ivanov", "Ivan", null);
        Person p5 = new Person("Ivanov", null, null);

        System.out.println(p1.getFIO());
//        System.out.println(p2.getFIO());
        System.out.println(p3.getFIO());
        System.out.println(p4.getFIO());
        System.out.println(p5.getFIO());

        /* OUTPUT:
        Ivanov I. I.
        Ivanov I.
        Ivanov I.
        Ivanov
         */

    }
}

