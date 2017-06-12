package fr.xebia.controller;

import fr.xebia.pojo.Person;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController("/person")
public class PersonController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    @ResponseBody
    public Person getPerson() {
        return Person.newRandomInstance();
    }

    @RequestMapping(value = "/mono", method = RequestMethod.GET)
    @ResponseBody
    public Mono<Person> getMonoPerson() {
        return Mono.just(Person.newRandomInstance());
    }

    @RequestMapping(value = "/flux", method = RequestMethod.GET)
    @ResponseBody
    public Flux<Person> getFluxPerson() {
        return Flux.just(Person.newRandomInstance(),
            Person.newRandomInstance(),
            Person.newRandomInstance());
    }

}
