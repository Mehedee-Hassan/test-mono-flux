package com.reactive.app;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;

import java.util.function.Consumer;

@SpringBootTest
public class MonoLearnTest {
    @Test
    void contextLoad(){

    }

    @Test
    void workingWithMono(){
        System.out.println("testing");
        Mono<String> testMono = Mono.just("test string from mono");

        testMono.subscribe(data -> {
            System.out.println("data is :" + data);
        });








        testMono.subscribe(new Subscriber<String>() {
            @Override
            public void onSubscribe(Subscription subscription) {

            }

            @Override
            public void onNext(String s) {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });


        testMono.subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) {

            }
        });


        }

}
