package com.RestApi.ReactiveWeb.Controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
public class MyController {

    @GetMapping("/demo")
    public Mono<String> greetMessage(){
        Mono<String> stringMono = computeMessage();
        System.out.println(stringMono);
        return stringMono;
    }

    @GetMapping("/zip")
    public Mono<String> zip2Mono() {
        return computeMessage().zipWith(getNameFromDB())
                .map(value ->
                {
                    return value.getT1() + value.getT2();
                });
    }

    private Mono<String> computeMessage(){
        System.out.println("Returning computeMessage");
        return Mono.just("Hello ").delayElement(Duration.ofSeconds(5));
    }

    private Mono<String> getNameFromDB(){
        System.out.println("Returning getNameFromDB");
        return Mono.just("World ").delayElement(Duration.ofSeconds(5));
    }


}
