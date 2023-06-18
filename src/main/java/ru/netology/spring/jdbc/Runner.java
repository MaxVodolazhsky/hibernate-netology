package ru.netology.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Runner.class);
        application.run(args);
    }

    @Override
    public void run(String... args) throws SQLException {
//        Map<String, Object> params = new HashMap<>();
//        params.put("firstName", "Maria");
//        params.put("id", 2);
//        List<Students> students = namedParameterJdbcTemplate.query(
//                "select* from netology.users where name = :firstName",
//                params,
//                (rs, rowNum) -> {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            int age = rs.getInt("age");
//            String address = rs.getString("address");
//            return new Students(id, name, age, address);
//        });
//
//        students.forEach(System.out::println);
//
//        jdbcTemplate.execute(String.format("insert into netology.students (id, name, age, address, surename) values(%d, '%s', %d, '%s', '%s')", 7, "Роман", 36, "Москва", "Иванов"));


//        List<Students> students = jdbcTemplate.query(
//                String.format("select* from netology.users where id=%d and age=%d and ", 5, 4),
//
//                (resultSet, rowNum) -> {
//            System.out.println("Номер строчки, на которой находится курсор: " + rowNum);
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            String address = resultSet.getString("address");
//            return new Students(id, name, age, address);
//        });
//        students.forEach(System.out::println);
//

//        students.forEach(System.out::println);
//
//        students.forEach(System.out::println);
//        List<Students> students = jdbcTemplate.query("select* from netology.students", (resultSet, rowNum) -> {
//            int id = resultSet.getInt("id");
//            String name = resultSet.getString("name");
//            int age = resultSet.getInt("age");
//            String address = resultSet.getString("address");
//            return new Students(id, name, age, address);
//        });

//        students.forEach(System.out::println);
//        List<Students> students = jdbcTemplate.query("select * from netology.students where name = ? and id = ?", (rs, rowNum) -> {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            int age = rs.getInt("age");
//            String address = rs.getString("address");
//            return new Students(id, name, age, address);
//        }, "Игорь", 3);
////
////
//        students.forEach(System.out::println);


//        Map<String, Object> map = new HashMap<>();
//        map.put("firstName", "Игорь");
//        map.put("id", 2);
//        List<Students> students = namedParameterJdbcTemplate.query(
//                "select* from netology.students where name = :firstName and id = :id",
//                map,
//                (rs, rowNum) -> {
//            int id = rs.getInt("id");
//            String name = rs.getString("name");
//            int age = rs.getInt("age");
//            String address = rs.getString("address");
//            return new Students(id, name, age, address);
//        });
//
//        students.forEach(System.out::println);
    }
}


class Students {

    private int id;
    private String name;
    private int age;
    private String address;

    public Students(int id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Students{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", address='" + address + '\'' +
               '}';
    }
}