package com.manage.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class HomeController {
	@RequestMapping
	public String home() {
		// this will returnname of calling file that will paste in controller.xml in as >> /WEB-INF/views/ index.jsp
		System.out.print("this is home or index page url");  
		return "index";
	}
}
