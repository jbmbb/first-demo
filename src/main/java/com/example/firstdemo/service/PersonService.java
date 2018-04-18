package com.example.firstdemo.service;

import java.util.List;

import com.example.firstdemo.domain.Person;

public interface PersonService {
	/**
	 * 查找相同姓名的人
	 * @param name
	 * @return
	 */
	List<Person> findByName(String name);
	
	/**
	 * 根据名字和年龄查找指定人
	 * @param name
	 * @param age
	 * @return
	 */
	Person findByNameAndAge(String name,int age);
	
	/**
	 * 根据id查询指定人
	 * @param id
	 * @return
	 */
	Person findPersonById(Long id);
	
	/**
	 * 新增
	 * @param person
	 */
	void save(Person person);
	
	/**
	 * 查询所有人
	 * @return
	 */
	List<Person> findAll();
	
	/**
	 * 判断指定人的年龄，测试自定义异常
	 * <10岁，抛出异常，提示还在上小学
	 * 10<age<16,抛出异常，提示还在上初中
	 * @param id
	 */
	void getAge(Long id);
}
