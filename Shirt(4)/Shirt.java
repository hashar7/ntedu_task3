package com.company;

public class Shirt {
    private String id;
    private String description;
    private String color;
    private String size;

    public Shirt() {
        id          = null;
        description = null;
        color       = null;
        size        = null;
    }

    public Shirt(String in) {
        String[] split = in.split(",");
        id          = split[0].trim();
        description = split[1].trim();
        color       = split[2].trim();
        size        = split[3].trim();
    }

    @Override
    public String toString() {
        return "Shirt{" + "\n" +
                "id='" + id + '\'' + "\n" +
                "description='" + description + '\'' +  "\n" +
                "color='" + color + '\'' + "\n" +
                "size='" + size + '\'' + "\n" +
                '}';
    }
}
