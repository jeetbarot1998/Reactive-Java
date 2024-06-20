package com.RestApi.ReactiveWeb.ReactiveDemo;

import java.io.IOException;
import java.util.List;

public class Exercise3 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumbersFlux()

        // Get all numbers in the ReactiveSources.intNumbersFlux stream
        // into a List and print the list and its size
        // This is blocking in nature as we wait for  the whole list to be populated
        List<Integer> number = ReactiveSources.
                intNumbersFlux()
                .log()
                .toStream()
                .toList();
        System.out.println(number);
        System.out.println("Size :" + number.size());

        System.out.println("Press a key to end");
        System.in.read();
    }

}
