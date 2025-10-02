package br.com.anderson.rest_spring_java.reporitory;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.anderson.rest_spring_java.model.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
