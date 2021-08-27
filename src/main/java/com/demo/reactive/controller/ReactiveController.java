package com.demo.reactive.controller;

import java.time.Duration;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.reactive.model.Foo;

import reactor.core.publisher.Flux;

@RestController
public class ReactiveController {
    @GetMapping(value = "/reactive/foo", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Foo> emitPersons() {
        return Flux.interval(Duration.ofSeconds(1))
                .map(val -> new Foo( 1, "Reactive"));
    }
}
