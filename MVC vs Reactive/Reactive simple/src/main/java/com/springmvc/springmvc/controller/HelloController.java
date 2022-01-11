package com.springmvc.springmvc.controller;

import com.springmvc.springmvc.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
	
	@Autowired
	private HelloWorldService helloService;

	
	@GetMapping("hi")
	public String sayHello() {
		return helloService.sayHello();
	}
}
