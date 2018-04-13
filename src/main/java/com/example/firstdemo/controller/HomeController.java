package com.example.firstdemo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
/**
 * 渲染页面的controller
 * @author xxlai
 *
 */
@Controller
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
		
		return "home";	//渲染数据到页面，页面路径：src\main\resources\templates\home.html
	}
	
	@RequestMapping("/home2")
	public String home2(ModelMap modelMap){
		modelMap.put("name", "xxlai2");
		
		List<String> list = new ArrayList<String>();
		list.add("xxlai e");
		list.add("xxlai f");
		list.add("xxlai g");
		list.add("xxlai h");
		modelMap.put("list", list);
		
		return "home";	//渲染数据到页面，页面路径：src\main\resources\templates\home.html
	}
	
}
