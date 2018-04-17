package com.example.firstdemo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.firstdemo.domain.Person;

public interface PersonRepository extends JpaRepository<Person, Long>{
	List<Person> findByName(String name);
	
	Person findByNameAndAge(String name,int age);
	
	@Query("FROM Person p WHERE p.id =:id")
	Person findPersonById(@Param("id") Long id);
}
