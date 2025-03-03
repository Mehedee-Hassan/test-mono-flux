package com.reactive.app;


import org.junit.jupiter.api.Test;
import org.reactivestreams.Subscriber;
import org.reactivestreams.Subscription;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

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


        Mono<String> testMono1 = Mono.just("test string 1");
        Mono<String> testMono2 = Mono.just("test string 1");

        Mono<Tuple2<String,String>> combinedMono
                = Mono.zip(testMono1,testMono2);

        combinedMono.subscribe(data->{
            System.out.println(data.getT1());
            System.out.println(data.getT2());
        });

        Mono<String[]> resultFlatMap =
                testMono1
                        .flatMap(value1
                                -> Mono
                                .just(
                                        value1
                                        .split(" ")
                                )).log();
        resultFlatMap.subscribe(data -> {
            System.out.println(data);
            for (var test :
                    data) {
                System.out.println(test);
            }
        });

        System.out.println("------------flux---------");

        Flux<String> stringFlux = testMono1.flatMapMany(value1 -> Flux.just(value1.split(" "))).log();
//      here not single value so not String[]
        stringFlux.subscribe(data -> {
            System.out.println(data);
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
