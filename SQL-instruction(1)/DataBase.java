package com.company;

import java.sql.Connection;
import java.sql.ResultSet;

public interface DataBase {

    /**
     * Метод создает новую таблицу.
     */
    public void createNewTable();

    /**
     * Метод выводит результат SQL-запроса
     * {@code SELECT * FROM TABLE_NAME}.
     */
    public void selectAll();

    /**
     * Метод выводит информациб о студенте с заданным именем и фамилией.
     *
     * @param firstName имя студента.
     * @param lastName  фамилия студента.
     */
    public void selectStudent(String firstName, String lastName);

    /**
     * Возвращает результат SQL-запроса
     * {@code SELECT * FROM TABLE_NAME} в виде {@code ResultSet}.
     *
     * @return {@code ResultSet}, содержащий все строки и столбцы заданной таблицы.
     * Для прямого доступа к информации в таблице можно пользоваться функциям
     * {@link java.sql.ResultSet#getString(String)} или {@link java.sql.ResultSet#getInt(String)}.
     */
    public ResultSet getTable();

    /**
     * Метод формирует и исполняет SQL-инструкцию, которая
     * вставляет строки в таблицу {@code T_GroupSelected} &lt;{@code id_Student,
     * firstName, lastName, id_Group}&gt; из таблицы
     * {@code T_Student}&lt;{@code id_Student, firstName, lastName, id_Group,
     * dolgCount}&gt; тех студентов, которые относятся к некоторой группе
     * (строковый параметр) и количество долгов (целочисленный параметр)
     * которых превышает заданное значение.
     *
     * @param id_Group  ID группы у студентов, которых необходимо выбрать.
     * @param dolgCount минимальное количество долгов, при котором студента не выбирают.
     */
    public void addStudents(int id_Group, int dolgCount);

    /**
     * Метод добавляет студента в таблицу.
     *
     * @param firstName имя студента.
     * @param lastName  фамилия студента.
     * @param id_Group  ID группы студента.
     * @param dolgCount количество долгов студента.
     */
    public void insert(String firstName, String lastName, int id_Group, int dolgCount);

    /**
     * Метод изменяет данные о студенте в таблице.
     *
     * @param OldFirstName старое имя студента.
     * @param OldLastName  старая фамилия студента.
     * @param firstName    новое имя студента.
     * @param lastName     новая фамилия студентаю
     * @param id_Group     новый ID группы студента.
     * @param dolgCount    новое количество долгов студента.
     */
    public void update(String OldFirstName, String OldLastName, String firstName, String lastName, int id_Group, int dolgCount);

    /**
     * Метод удаляет из таблицы студента с заданным именем и фамилией.
     *
     * @param firstName имя студента, котрого надо удалить.
     * @param lastName  фамилия студента, которого надо удалить.
     */
    public void delete(String firstName, String lastName);

}

