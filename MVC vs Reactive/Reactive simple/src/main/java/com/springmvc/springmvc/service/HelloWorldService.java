package com.springmvc.springmvc.service;

import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class HelloWorldService {

	public String sayHello() {
		
		
		 try {
			TimeUnit.SECONDS.sleep(10);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return "Hello My Dear. Welcome to Spring Boot MVC. Which is Blocking API";
	}

}
