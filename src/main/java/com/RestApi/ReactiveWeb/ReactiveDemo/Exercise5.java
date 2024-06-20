package com.RestApi.ReactiveWeb.ReactiveDemo;

import org.reactivestreams.Subscription;
import reactor.core.publisher.BaseSubscriber;

import java.io.IOException;

public class Exercise5 {

    public static void main(String[] args) throws IOException {

        // Use ReactiveSources.intNumberMono() and ReactiveSources.userMono()

        // Subscribe to a flux using the error and completion hooks
//        Disposable subscribe = ReactiveSources.intNumbersFlux().subscribe(
//                (val -> System.out.println(val)),
//                (err -> System.out.println("error is " + err.getMessage())),
//                (() -> System.out.println("completed"))
//        );

        // Subscribe to a flux using an implementation of BaseSubscriber
//        Back Pressure
        ReactiveSources.intNumbersFlux().subscribe(
                new mySubscriber<>());


        System.out.println("Press a key to end");
        System.in.read();
    }

}


class mySubscriber<T> extends BaseSubscriber<T> {
    @Override
    protected void hookOnSubscribe(Subscription subscription) {
        System.out.println("Subscribe Happened");
//        When I subscribe, I am okay with handling 2 item whenever it is ready
        request(2);
//        Now it will call hookOnNext()
    }

    @Override
    protected void hookOnNext(T value) {
        System.out.println(value.toString() + " received");
//        I am okay with handling 1 another
//        item whenever it is ready
        request(1);
    }

    @Override
    protected void hookOnComplete() {
        System.out.println("hookOnComplete");
    }

    @Override
    protected void hookOnError(Throwable throwable) {
        System.out.println("hookOnError");
    }

    @Override
    protected void hookOnCancel() {
        System.out.println("hookOnCancel");
    }
}