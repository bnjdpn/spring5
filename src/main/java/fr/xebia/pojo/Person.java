package fr.xebia.pojo;

import java.util.UUID;

public class Person {

    private String id;

    private String lastname;

    private String firstname;

    public static Person newRandomInstance() {
        Person person = new Person();
        person.setId(UUID.randomUUID().toString());
        person.setLastname("Lastname " + person.getId());
        person.setFirstname("Firstname " + person.getId());
        return person;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

}
