package com.example.firstdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {

	@RequestMapping("/home")
	public String home(ModelMap modelMap){
		modelMap.put("name", "xxlai");
		
		List<String> list = new ArrayList<String>();
		list.add("xxlai a");
		list.add("xxlai b");
		list.add("xxlai c");
		list.add("xxlai d");
		modelMap.put("list", list);
		
		return "home";
	}
	
}
