package ru.netology.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.netology.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Long> {
}
