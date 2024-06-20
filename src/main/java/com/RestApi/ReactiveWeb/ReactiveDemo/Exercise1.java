package com.RestApi.ReactiveWeb.ReactiveDemo;

public class Exercise1 {

    public static void main(String[] args) {
        System.out.println("=== Print all numbers ===");
        StreamSources.intNumbersStream().forEach(p -> System.out.println(p));

        System.out.println("=== Print numbers from intNumbersStream that are less than 5 ===");
        StreamSources.intNumbersStream().filter(p -> p < 5).forEach(System.out::println);

        System.out.println("=== Print the second and third numbers in intNumbersStream that's greater than 5 ===");
        StreamSources.intNumbersStream()
                .filter(p -> p > 5)
                .skip(1)
                .limit(2)
                .forEach(System.out::println);

        System.out.println("=== Print the first number in intNumbersStream that's greater than 5. \n" +
                "If nothing is found, print -1 ===");
        Integer val = StreamSources.intNumbersStream()
                .filter(p -> p > 5)
                .findFirst().orElse(-1);
        System.out.println(val);

        System.out.println("=== Print first names of all users in userStream ===");
        StreamSources.userStream()
                .forEach(p -> System.out.println(p.getFirstName()));

    }

}
