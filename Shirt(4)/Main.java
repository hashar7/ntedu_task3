package com.company;

public class Main {

    public static void main(String[] args) {
        
        String[] shirts = new String[11];
        Shirt[]  shirt  = new Shirt[11];
        shirts[0]  = "S001,Black Polo Shirt,Black,XL";
        shirts[1]  = "S002,Black Polo Shirt,Black,L";
        shirts[2]  = "S003,Blue Polo Shirt,Blue,XL";
        shirts[3]  = "S004,Blue Polo Shirt,Blue,M";
        shirts[4]  = "S005,Tan Polo Shirt,Tan,XL";
        shirts[5]  = "S006,Black T-Shirt,Black,XL";
        shirts[6]  = "S007,White T-Shirt,White,XL";
        shirts[7]  = "S008,White T-Shirt,White,L";
        shirts[8]  = "S009,Green T-Shirt,Green,S";
        shirts[9]  = "S010,Orange T-Shirt,Orange,S";
        shirts[10] = "S011,Maroon Polo Shirt,Maroon,S";

        for (int i = 0; i < 11; i++) {
            shirt[i] = new Shirt(shirts[i]);
        }

        for (int i = 0; i < 11; i++) {
            System.out.println(shirt[i].toString() + "\n");
        }

        /* OUTPUT:
        Shirt{
        id='S001'
        description='Black Polo Shirt'
        color='Black'
        size='XL'
        }

        Shirt{
        id='S002'
        description='Black Polo Shirt'
        color='Black'
        size='L'
        }

        Shirt{
        id='S003'
        description='Blue Polo Shirt'
        color='Blue'
        size='XL'
        }

        Shirt{
        id='S004'
        description='Blue Polo Shirt'
        color='Blue'
        size='M'
        }

        Shirt{
        id='S005'
        description='Tan Polo Shirt'
        color='Tan'
        size='XL'
        }

        Shirt{
        id='S006'
        description='Black T-Shirt'
        color='Black'
        size='XL'
        }

        Shirt{
        id='S007'
        description='White T-Shirt'
        color='White'
        size='XL'
        }

        Shirt{
        id='S008'
        description='White T-Shirt'
        color='White'
        size='L'
        }

        Shirt{
        id='S009'
        description='Green T-Shirt'
        color='Green'
        size='S'
        }

        Shirt{
        id='S010'
        description='Orange T-Shirt'
        color='Orange'
        size='S'
        }

        Shirt{
        id='S011'
        description='Maroon Polo Shirt'
        color='Maroon'
        size='S'
        }

         */

    }
}

