package com.example.firstdemo.service.impl;

import java.util.List;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.firstdemo.conf.MyException;
import com.example.firstdemo.constance.ExceptionEnum;
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

	@Transactional
	@Override
	public void save(Person person) {
		personRepository.save(person);
	}

	@Override
	public List<Person> findAll() {
		return personRepository.findAll();
	}

	@Override
	public void getAge(Long id) {
		Person person = personRepository.getOne(id);
		if(person.getAge()<10){
			throw new MyException(ExceptionEnum.PRIMARY_SCHOOL);
		}else if(person.getAge()>10 && person.getAge() <16){
			throw new MyException(ExceptionEnum.MIDDLE_SCHOOL);
		}
	}

}
