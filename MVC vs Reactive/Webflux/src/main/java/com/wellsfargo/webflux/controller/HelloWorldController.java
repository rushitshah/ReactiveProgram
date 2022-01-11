package com.wellsfargo.webflux.controller;

import com.wellsfargo.webflux.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class HelloWorldController {
	
	@Autowired
	public HelloWorldService helloService;
	
	@GetMapping("hi")
	public Mono<String> helloWorld(){
		
		return helloService.sayHello();
		
		
	}

}
