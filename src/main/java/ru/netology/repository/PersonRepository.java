package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.netology.entity.Person;
import ru.netology.entity.enums.Gender;

import java.util.List;
import java.util.Optional;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    List<Person> findByGenderAndAgeGreaterThan(Gender gender, int age);

    @Query(value = "select p from Person p where p.gender = :gender")
    List<Person> findByGenderJpqlQuery(Gender gender);

    @Query(value = "select * from person p where p.gender = :gender", nativeQuery = true)
    List<Person> findByGenderNativeQuery(String gender);
}
