package com.wellsfargo.springclient;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@SpringBootApplication
public class SpringClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringClientApplication.class, args);
    }


    @Bean
    public CommandLineRunner start() {

        return args -> {


            long startTime = System.currentTimeMillis();
            WebClient webClient = WebClient.builder().baseUrl("http://localhost:8082/hi").build();
            ExecutorService es = Executors.newFixedThreadPool(600);

            for(int i=0;i< 600;i++) {

                final int j = i;
                es.submit( () -> {
                    String message = webClient.get().retrieve().bodyToMono(String.class).block();
                    System.out.println(j+ ":: Response From Service "+message);
                });
            }
            es.shutdown();
            while(!es.isTerminated()) {
                System.out.println(System.currentTimeMillis() - startTime);
            }

        };

    }

}
