package fr.xebia.controller;

import fr.xebia.model.Person;
import java.util.stream.IntStream;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class PersonController {

    @GetMapping(value = "/person", produces = MediaType.APPLICATION_JSON_VALUE)
    public Mono<Person> getRandomPerson() {

        return Mono.just(Person.newRandomInstance());
    }

    @GetMapping(value = "/person/{numberOfPeople}", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Person> getRandomPeople(@PathVariable Integer numberOfPeople) {

        return Flux.fromStream(IntStream.range(0, numberOfPeople)
            .mapToObj(i -> Person.newRandomInstance()));
    }
}
