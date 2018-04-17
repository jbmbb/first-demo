package com.example.firstdemo.service;

import java.util.List;

import com.example.firstdemo.domain.Person;

public interface PersonService {
	
	List<Person> findByName(String name);
	
	Person findByNameAndAge(String name,int age);
	
	Person findPersonById(Long id);
	
	void save(Person person);
}
