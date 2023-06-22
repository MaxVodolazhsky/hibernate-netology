package ru.netology.entity;

import lombok.*;
import ru.netology.entity.enums.Gender;

import javax.persistence.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false, length = 212)
    private String name;

    @Column(nullable = false)
    private int age;

    @Enumerated(EnumType.STRING)
    @Column(length = 20)
    private Gender gender;

    @Embedded
    private Contact contact;

    @ManyToOne(optional = false)
    private City city;

    @Override
    public String toString() {
        return "Person{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", age=" + age +
               ", gender=" + gender +
               ", contact=" + contact +
               ", city=" + city +
               '}';
    }
}
