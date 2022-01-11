package com.wellsfargo.webflux.service;

import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.time.Duration;


@Service
public class HelloWorldService {

	public Mono<String> sayHello() {
		
		return Mono.delay(Duration.ofSeconds(10)).then(Mono.just("Hello My Dear. Welcome to String Web Flux. Non Blocking API."));
		
		
	}

}
