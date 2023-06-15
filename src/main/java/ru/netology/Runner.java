package ru.netology;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.transaction.annotation.Transactional;
import ru.netology.entity.City;
import ru.netology.entity.Person;
import ru.netology.entity.enums.Gender;
import ru.netology.repository.CityRepository;
import ru.netology.repository.PersonRepository;

import java.util.List;
import java.util.Optional;

@SpringBootApplication
public class Runner implements CommandLineRunner {

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private PersonRepository personRepository;

    public static void main(String[] args) {
        SpringApplication application = new SpringApplication(Runner.class);
        application.run(args);
    }

    public Runner(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Transactional
    @Override
    public void run(String... args) {
        List<Person> byGenderJpqlQuery = personRepository.findByGenderNativeQuery(Gender.FEMALE.name());
        byGenderJpqlQuery.forEach(System.out::println);
    }
}