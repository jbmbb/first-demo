package com.example.firstdemo.service;

import com.example.firstdemo.domain.Person;

public interface PersonService {
	
	Person findByName(String name);
	
	Person findByNameAndAge(String name,int age);
	
	Person findPersonById(Long id);
	
	void save(Person person);
}
