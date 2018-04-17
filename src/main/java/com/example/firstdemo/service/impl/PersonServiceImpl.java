package com.example.firstdemo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.firstdemo.domain.Person;
import com.example.firstdemo.repository.PersonRepository;
import com.example.firstdemo.service.PersonService;

@Service(value="personService")
public class PersonServiceImpl implements PersonService {
	
	@Autowired
	private PersonRepository personRepository;

	@Override
	public List<Person> findByName(String name) {
		return personRepository.findByName(name);
	}

	@Override
	public Person findByNameAndAge(String name, int age) {
		return personRepository.findByNameAndAge(name, age);
	}

	@Override
	public Person findPersonById(Long id) {
		return personRepository.findPersonById(id);
	}

	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

}
