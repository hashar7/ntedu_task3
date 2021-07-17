package com.company;

public class Main {

    public static void main(String[] args) {

        DataBase db1 = new DataBaseImpl("/Users/mikhail/sqlite/db/", "T_Student");
        DataBase db2 = new DataBaseImpl("/Users/mikhail/sqlite/db/", "T_GroupSelected");

        db2.createNewTable();
        db1.createNewTable();

        db1.insert("Bob", "Bobster", 101, 2);
        db1.insert("Coc", "Cocster", 101, 0);
        db1.insert("Lal", "Lalster", 103, 8);
        db1.insert("Pop", "Popster", 105, 5);
        db1.insert("Rep", "Repster", 101, 10);
        db1.insert("Nop", "Nopster", 105, 0);
        db1.insert("Cop", "Copster", 108, 9);
        db1.insert("Vop", "Vopster", 101, 2);

        db1.update("Bob", "Bobster", "Rop", "Ropster", 301, 22);
        db1.delete("Cop", "Copster");

        db1.selectStudent("Lal", "Lalster");

        db2.addStudents(101, 0);

        System.out.println("DB1:");
        db1.selectAll();

        System.out.println("DB2:");
        db2.selectAll();

        /* OUTPUT:
        The driver name is SQLite JDBC
        A new database has been created.
        Its name: T_Student

        The driver name is SQLite JDBC
        A new database has been created.
        Its name: T_GroupSelected

        T_GroupSelected table has been created

        T_Student table has been created

        3	Lal	Lalster	103	8
        Here
        DB1:
        1	Rop	Ropster	301	22
        2	Coc	Cocster	101	0
        3	Lal	Lalster	103	8
        4	Pop	Popster	105	5
        5	Rep	Repster	101	10
        6	Nop	Nopster	105	0
        8	Vop	Vopster	101	2
        DB2:
        5	Rep	Repster	101
        8	Vop	Vopster	101
         */

    }
}

