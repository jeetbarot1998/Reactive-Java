package com.RestApi.ReactiveWeb.ReactiveDemo;

import java.io.IOException;

public class Exercise7 {


    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Print all values from intNumbersFlux that's greater than 5
        System.out.println("Print all values from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .log()
                .filter(x -> x > 5)
                .subscribe(System.out::println);

        // Print 10 multiplied each value from intNumbersFlux that's greater than 5
        System.out.println("Print 10 multiplied each value from intNumbersFlux that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .map(x -> x * 10)
                .subscribe(System.out::println);

        // Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5
        System.out.println("Print 10 times each value from intNumbersFlux for the first 3 numbers emitted that's greater than 5");
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 5)
                .take(3)
                .map(x -> x * 10)
                .subscribe(System.out::println);

        // Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found
        System.out.println("Print each value from intNumbersFlux that's greater than 20. Print -1 if no elements are found");
        ReactiveSources.intNumbersFlux()
                .filter(x -> x > 20)
                .defaultIfEmpty(-1)
                .subscribe(System.out::println);

        // Switch ints from intNumbersFlux to the right user from userFlux
        // TODO: Write code here
        ReactiveSources.intNumbersFlux()
                .flatMap(id -> ReactiveSources.userFlux().filter(u -> u.getId() == id))
                .subscribe(System.out::println);

        // Print only distinct numbers from intNumbersFluxWithRepeat
        ReactiveSources.intNumbersFluxWithRepeat()
                .log()
                .distinct()
                .subscribe(System.out::println);

        // Print from intNumbersFluxWithRepeat excluding immediately repeating numbers
        ReactiveSources.intNumbersFluxWithRepeat()
                .distinctUntilChanged()
                .subscribe(System.out::println);

        System.out.println("Press a key to end");
        System.in.read();
    }

}
