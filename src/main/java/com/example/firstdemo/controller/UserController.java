package com.example.firstdemo.controller;

import java.util.concurrent.ConcurrentMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstdemo.domain.User;
import com.example.firstdemo.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(){
		return "hello world!";
	}
	
	@GetMapping("/query")
	public User getUser(String name){
		return userRepository.queryUser(name);
	}
	
	@GetMapping("/queryAll")
	public ConcurrentMap<Integer, User> queryUser(){
		return userRepository.queryAllUsers();
	}
	
	@DeleteMapping("/delete")
	public ConcurrentMap<Integer, User> delUser(String name){
		userRepository.delUser(name);
		return userRepository.queryAllUsers();
	}
	
	@PostMapping("/add")
	public boolean addUser(String name){
		User user = new User();
		user.setName(name);
		try {
			return userRepository.saveUser(user);
		} catch (Exception e) {
			return false;  //如果抛出异常，前台会怎么展示？？？
		}
	}
	
	@PutMapping("update")
	public void updateUser(String name){
		User user = new User();
		user.setName(name);
		user.setAge(18);
		userRepository.updateUser(user);
	}
	
}
