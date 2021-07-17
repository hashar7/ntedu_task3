package com.company;

public class Person {

    private String surname;
    private String name;
    private String patronymic;

    public Person() {
        surname = null;
        name = null;
        patronymic = null;
    }

    public Person(String surname, String name, String patronymic) {
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    public String toString() {
        return "Person{" +
                "surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                '}';
    }

    public String getFIO() throws IllegalStateException {
        if (surname == null || surname.equals("")) {
            throw new IllegalStateException();
        }
        StringBuilder fio = new StringBuilder();
        fio.append(surname)
                .append(name == null ? "" : String.format(" %s.", name.charAt(0)))
                .append(patronymic == null ? "" : String.format(" %s.", patronymic.charAt(0)));
        return fio.toString();
    }

}
