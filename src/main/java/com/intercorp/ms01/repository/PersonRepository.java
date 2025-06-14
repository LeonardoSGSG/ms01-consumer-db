package com.intercorp.ms01.repository;

import com.intercorp.ms01.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
  boolean existsByEmail(String email);
}
