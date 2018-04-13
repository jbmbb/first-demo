package com.example.firstdemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstdemo.domain.Person;
import com.example.firstdemo.service.PersonService;

@RequestMapping("/person")
@RestController
public class PersonController {
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(method=RequestMethod.GET)
	public Person index(){
		Person person = new Person();
		person.setName("xxlai");
		person.setAge(18);
		personService.save(person);
		
		Person temp = personService.findByName("xxlai");
		return temp;
	}
}