package com.RestApi.ReactiveWeb.ReactiveDemo;

import java.io.IOException;
import java.util.Optional;

public class Exercise4 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono()

        // Print the value from intNumberMono when it emits
        ReactiveSources.intNumberMono().subscribe(
                e -> System.out.println(e)
        );

        // Get the value from the Mono into an integer variable
        Optional<Integer> numoptional = ReactiveSources.intNumberMono().blockOptional();


        System.out.println("Press a key to end");
        System.in.read();
    }

}
