package com.company;

public class Main {

    public static void main(String[] args) {
        Address a1 = new Address("Russia", "Central", "Moscow", "Leninskie gory", "1", "1", "34");
        System.out.println(a1.toString());
        a1.setAddress("     Russian Federation, Central, Moscow, Krasnaya Polyana, 37, 1, 31  ");
        System.out.println(a1.toString());
        a1.setAddress("     Russian Federation; Central; Moscow. Krasopresnenskaya emb.; 1, 2; 3;  ");
        System.out.println(a1.toString());

        /* OUTPUT:
        Address{country='Russia', region='Central', city='Moscow', street='Leninskie gory', house='1', building='1', flat='34'}
        Address{country='Russian Federation', region='Central', city='Moscow', street='Krasnaya Polyana', house='37', building='1', flat='31'}
        Address{country='Russian Federation', region='Central', city='Moscow', street='Krasopresnenskaya emb', house='1', building='2', flat='3'}
         */

    }
}

