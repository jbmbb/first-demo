package com.example.firstdemo.controller;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.firstdemo.conf.MyException;
import com.example.firstdemo.constance.ExceptionEnum;

/**
 * @RestControllerAdvice测试类
 * @author xxlai
 *
 */
@RestController
@RequestMapping("/advice")
public class MyAdviceController {

	@RequestMapping("/home")
	public String home(ModelMap modelMap){
		System.out.println("author:"+modelMap.get("author"));
		System.out.println("name:"+modelMap.get("name"));
		System.out.println("list:"+modelMap.get("list"));
		
		return String.valueOf(modelMap.get("author"));
	}
	
	@RequestMapping("/exception")
	public void getException(){
		throw new MyException(ExceptionEnum.SUCCESS);
	}
	
	/*@RequestMapping("/home")
	public String home(@ModelAttribute("author") String author){
		System.out.println(author);
		return author;
	}*/
}
