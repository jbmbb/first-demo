package com.example.firstdemo.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.example.firstdemo.aspect.HttpAspect;
import com.example.firstdemo.domain.Person;
import com.example.firstdemo.service.PersonService;

@RestController
@RequestMapping("/person")
public class PersonController {
	private static Logger logger = LoggerFactory.getLogger(PersonController.class);
	
	@Autowired
	private PersonService personService;
	
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> index(@RequestParam(name="name") String userName){
		Person person = new Person();
		person.setName("xxlai");
		person.setAge(18);
		personService.save(person);
		
		List<Person> persons = personService.findByName(userName);
		return persons;
	}
	
	@RequestMapping(value="getList",method=RequestMethod.GET)
	public List<Person> getAll(){
		logger.info("getList");
		return personService.findAll();
	}
	
}
