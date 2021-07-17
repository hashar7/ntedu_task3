package com.company;

import java.sql.*;

public class DataBaseImpl implements DataBase {

    private String path;
    private String name;

    /**
     * Конструктор, который создает базу данных по заданному пути с заданным именем.
     *
     * @param path путь к файлу базы данных.
     * @param name имя таблицы.
     */
    public DataBaseImpl(String path, String name) {
        this.path = path;
        this.name = name;
        String url = "jdbc:sqlite:" + path + "StudentsDB" + ".db";
        try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
                System.out.println("Its name: " + this.name + "\n");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод создает новую таблицу.
     */
    @Override
    public void createNewTable() {
        String url = "jdbc:sqlite:" + path + "StudentsDB" + ".db";
        String sql = null;
        if (name.equals("T_Student")) {
            sql = "CREATE TABLE IF NOT EXISTS T_Student (\n"
                    + "	\"id_Student\" integer PRIMARY KEY,\n"
                    + "	\"firstName\" text NOT NULL,\n"
                    + " \"lastName\" text NOT NULL,\n"
                    + "	\"id_Group\" integer,\n"
                    + " \"dolgCount\" integer\n"
                    + ");";
            System.out.println("T_Student table has been created\n");
        } else if (name.equals("T_GroupSelected")) {
            sql = "CREATE TABLE IF NOT EXISTS T_GroupSelected (\n"
                    + "	\"id_Student\" integer PRIMARY KEY,\n"
                    + "	\"firstName\" text NOT NULL,\n"
                    + " \"lastName\" text NOT NULL,\n"
                    + "	\"id_Group\" integer\n"
                    + ");";
            System.out.println("T_GroupSelected table has been created\n");
        }
        try (Connection conn = DriverManager.getConnection(url);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод создает соединение с данной базой данных.
     *
     * @return
     */
    private Connection connect() {
        String url = "jdbc:sqlite:" + path + "StudentsDB" + ".db";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    /**
     * Метод выводит результат SQL-запроса
     * {@code SELECT * FROM TABLE_NAME}.
     */
    @Override
    public void selectAll() {
        String sql = "SELECT * FROM " + this.name;// + " WHERE id_Group = 101";
        try (Connection conn = this.connect();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (columnCount == 4) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id_Student") + "\t" +
                            rs.getString("firstName") + "\t" +
                            rs.getString("lastName") + "\t" +
                            rs.getInt("id_Group"));
                }
            } else if (columnCount == 5) {
                while (rs.next()) {
                    System.out.println(rs.getInt("id_Student") + "\t" +
                            rs.getString("firstName") + "\t" +
                            rs.getString("lastName") + "\t" +
                            rs.getInt("id_Group") + "\t" +
                            rs.getInt("dolgCount"));
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод выводит информациб о студенте с заданным именем и фамилией.
     *
     * @param firstName имя студента.
     * @param lastName  фамилия студента.
     */
    @Override
    public void selectStudent(String firstName, String lastName) {
        String sql = "SELECT * "
                + "FROM " + this.name + " WHERE firstName = ? AND lastName = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            ResultSet rs = pstmt.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();
            if (columnCount == 4) {
                System.out.println(rs.getInt("id_Student") + "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName") + "\t" +
                        rs.getInt("id_Group"));
            } else if (columnCount == 5) {
                System.out.println(rs.getInt("id_Student") + "\t" +
                        rs.getString("firstName") + "\t" +
                        rs.getString("lastName") + "\t" +
                        rs.getInt("id_Group") + "\t" +
                        rs.getInt("dolgCount"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Возвращает результат SQL-запроса
     * {@code SELECT * FROM TABLE_NAME} в виде {@code ResultSet}.
     *
     * @return {@code ResultSet}, содержащий все строки и столбцы заданной таблицы.
     * Для прямого доступа к информации в таблице можно пользоваться функциям
     * {@link java.sql.ResultSet#getString(String)} или {@link java.sql.ResultSet#getInt(String)}.
     */
    @Override
    public ResultSet getTable() {
        String sql = "SELECT * FROM " + name;
        ResultSet result = null;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            result = pstmt.executeQuery();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return result;
    }

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
    @Override
    public void addStudents(int id_Group, int dolgCount) {
        if (!this.name.equals("T_GroupSelected")) {
            System.out.println("No access");
            return;
        }
        String sql = "INSERT INTO T_GroupSelected(\"id_Student\",\"firstName\",\"lastName\",\"id_Group\") " +
                "SELECT T_Student.id_Student, T_Student.firstName, T_Student.lastName, T_Student.id_Group " +
                "FROM T_Student WHERE T_Student.id_Group = " + id_Group + " AND T_Student.dolgCount > " + dolgCount;
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }

    /**
     * Метод добавляет студента в таблицу.
     *
     * @param firstName имя студента.
     * @param lastName  фамилия студента.
     * @param id_Group  ID группы студента.
     * @param dolgCount количество долгов студента.
     */
    @Override
    public void insert(String firstName, String lastName, int id_Group, int dolgCount) {
        if (this.name.equals("T_GroupSelected")) {
            System.out.println("No access");
            return;
        }
        String sql = "INSERT INTO T_Student(\"firstName\",\"lastName\",\"id_Group\",\"dolgCount\") VALUES(?,?,?,?)";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setDouble(3, id_Group);
            pstmt.setDouble(4, dolgCount);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

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
    @Override
    public void update(String OldFirstName, String OldLastName, String firstName, String lastName, int id_Group, int dolgCount) {
        if (this.name.equals("T_GroupSelected")) {
            System.out.println("No access");
            return;
        }
        String sql = "UPDATE T_Student SET firstName = ? , "
                + "lastName = ? , "
                + "id_Group = ? , "
                + "dolgCount = ? "
                + "WHERE firstName = ? AND lastName = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.setInt(3, id_Group);
            pstmt.setInt(4, dolgCount);
            pstmt.setString(5, OldFirstName);
            pstmt.setString(6, OldLastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Метод удаляет из таблицы студента с заданным именем и фамилией.
     *
     * @param firstName имя студента, котрого надо удалить.
     * @param lastName  фамилия студента, которого надо удалить.
     */
    @Override
    public void delete(String firstName, String lastName) {
        String sql = "DELETE FROM T_Student WHERE firstName = ? AND lastName = ?";
        try (Connection conn = this.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, firstName);
            pstmt.setString(2, lastName);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
