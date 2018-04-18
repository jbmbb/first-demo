package com.example.firstdemo.conf;

import java.util.HashMap;
import java.util.Map;

import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @ControllerAdvice 拦截异常并统一处理
 * @author xxlai
 *
 */
@RestControllerAdvice
public class MyControllerAdvice {
	
	/**
	 * 应用到所有@RequestMapping注解方法，在其执行之前初始化数据绑定器
	 * @param binder
	 */
	@InitBinder
	public void initBinder(WebDataBinder binder){}
	
	/**
	 * 把值绑定到Model中，使全局@RequestMapping可以获取到该值
	 * @param model
	 */
	@ModelAttribute
	public void addAttribute(Model model){
		model.addAttribute("author", "xxlai");
	}
	
	/**
	 * 全局异常捕捉处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public Map errorHandler(Exception ex){
		Map map = new HashMap();
		map.put("code", 100);
		map.put("msg", ex.getMessage());
		return map;
	}
	
	/**
	 * 自定义异常捕捉处理
	 * @param ex
	 * @return
	 */
	@ExceptionHandler
	public Map myErrorHandler(MyException ex){
		Map map = new HashMap();
		map.put("code", 101);
		map.put("msg", ex.getMessage());
		return map;
	}
	
}
