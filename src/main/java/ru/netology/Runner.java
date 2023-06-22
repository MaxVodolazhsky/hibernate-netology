package ru.netology;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.entity.City;
import ru.netology.entity.Contact;
import ru.netology.entity.Person;
import ru.netology.entity.enums.Gender;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @PersistenceContext
    private EntityManager entityManager;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Runner.class);
        application.run(args);
    }

    @Override
    @Transactional
    public void run(String... args) {

        Person person = entityManager.find(Person.class, 3L);


        entityManager.remove(person);
    }
}