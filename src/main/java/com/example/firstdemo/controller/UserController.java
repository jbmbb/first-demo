package com.example.firstdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstdemo.domain.User;
import com.example.firstdemo.repository.UserRepository;

@Api(value="用户模块")
@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@ApiOperation(value="hello测试方法",notes="hello 测试方法")
	@RequestMapping(value="/hello",method=RequestMethod.GET)
	public String sayHello(){
		return "hello world!";
	}
	
	@ApiOperation(value="获取单个用户",notes="传入name获取单个用户")
	@GetMapping("/query/{name}")
	public User getUser(
			@ApiParam(value = "用户名", required = true) @PathVariable String name) {
		return userRepository.queryUser(name);
	}
	
	@ApiOperation(value="获取用户列表",notes="获取用户列表")
	@GetMapping("/queryAll")
	public List<User> queryUser(){
		return userRepository.queryAllUsers();
	}
	
	@ApiOperation(value="删除单个用户",notes="传入name删除单个用户")
	@DeleteMapping("/delete/name")
	public List<User> delUser(@ApiParam(value = "用户名", required = true) @PathVariable String name){
		userRepository.delUser(name);
		return userRepository.queryAllUsers();
	}
	
	@ApiOperation(value="添加单个用户",notes="传入name添加单个用户")
	@PostMapping("/add/name")
	public boolean addUser(@ApiParam(value = "用户名", required = true) @PathVariable String name){
		User user = new User();
		user.setName(name);
		try {
			return userRepository.saveUser(user);
		} catch (Exception e) {
			return false;  //如果抛出异常，前台会怎么展示？？？
		}
	}
	
	@ApiOperation(value = "更新用户", notes = "更新已存在用户")
	@ApiImplicitParam(name = "user", value = "用户数据", required = true, paramType = "body", dataType = "User")
	@PutMapping("/update/name")
	public List<User> updateUser(@RequestBody String name){
		User user = new User();
		user.setName(name);
		user.setAge(18);
		userRepository.updateUser(user);
		return userRepository.queryAllUsers();
	}
	
}
