package com.example.firstdemo.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 配置静态资源映射
 * @author xxlai
 *
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

	//将所有/static/** 访问都映射到classpath:/static/ 目录下
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
	}
	 
}
