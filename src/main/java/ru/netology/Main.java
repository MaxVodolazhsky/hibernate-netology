package ru.netology;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/mrx_db?user=mrx&password=123");

        Statement statement = connection.createStatement();

//        executeInsert(9, "'Max'", 27, "'Moscow'", statement);
//
//        ResultSet resultSet = statement.executeQuery("select* from netology.users");
//
//        while (resultSet.next()) {
//            System.out.print(resultSet.getInt("id") + " ");
//            System.out.print(resultSet.getString(2) + " ");
//            System.out.print(resultSet.getInt("age") + " ");
//            System.out.print(resultSet.getString(4) + "\n");
//        }




        CallableStatement callableStatement = connection.prepareCall("select gen_random_uuid ()");

        ResultSet resultSet = callableStatement.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString(1));
        }

        statement.close();
        connection.close();
//        Statement statement = connection.createStatement();

//        ResultSet resultSet = statement.executeQuery("select* from netology.students");
//
//        while (resultSet.next()) {
//            int id = resultSet.getInt(1);
//            String name = resultSet.getString(2);
//            int age = resultSet.getInt(3);
//            String surename = resultSet.getString(4);
//
//            System.out.printf("Id: %d Name: %s Surename: %s Age: %d\n", id, name, surename, age);
//        }

//        statement.execute(String.format("insert into netology.students (id, name, age, address, surename) values(%d, '%s', %d, '%s', '%s')", 6, "Игорь", 35, "Москва", "Иванов"));



//        statement.close();
//        connection.close();


//        String jdbcUrl = "jdbc:postgresql://localhost:5432/mrx_db?user=mrx&password=123";
//        Connection connection = DriverManager.getConnection(jdbcUrl);
//
//        Statement statement = connection.createStatement();
//
//        executeInsert(3, "'Петр'", 35, "'Питер'", statement);
//
//        ResultSet resultSet = statement.executeQuery("select* from netology.students");
//        while (resultSet.next()) {
//            int id = resultSet.getInt( "id");
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            String address = resultSet.getString("address");
//
//            System.out.printf("%d. %s %d %s%n", id, name, age, address);
//        }
//
//        callableStatement.close();
//        connection.close();
    }

    private static void executeInsert(int id, String name, int age, String address, Statement statement) throws SQLException {
        String sqlQuery = String.format("insert into netology.users (id, name, age, address) "
                                      + "values(%d, %s, %d, %s)", id, name, age, address);
        System.out.println(sqlQuery);
        statement.execute(sqlQuery);
    }
}
