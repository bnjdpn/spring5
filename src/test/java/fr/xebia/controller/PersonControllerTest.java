package fr.xebia.controller;

import fr.xebia.model.Person;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonControllerTest {

    private WebTestClient webClient;

    @Before
    public void setUp() {
        webClient = WebTestClient.bindToServer().baseUrl("http://localhost:8080").build();
    }

    @Test
    public void testMono() {

        webClient.get().uri("/person").exchange().expectStatus().isOk().expectHeader()
            .contentType(MediaType.APPLICATION_JSON_UTF8).expectBody(Person.class);
    }

    @Test
    public void fluxTest() {

        final Integer numberOfPeople = 10;

        final WebTestClient.ResponseSpec
            responseSpec =
            webClient.get().uri("/person/{numberOfPeople}", numberOfPeople)
                .accept(MediaType.TEXT_EVENT_STREAM).exchange().expectStatus().isOk().expectHeader()
                .contentType(MediaType.TEXT_EVENT_STREAM);

        responseSpec.returnResult(Person.class).getResponseBody().toStream()
            .forEach(System.out::println);

    }
}
