package com.spring_boot.person;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Repository
public class FakePersonRepository {

    private final AtomicInteger counter = new AtomicInteger(0);
    private  List<Person> people = new ArrayList<>();

     {
        people.add(new Person(counter.incrementAndGet(),"John",20,Gender.MALE,"john@gmail.com"));
        people.add(new Person(counter.incrementAndGet(),"Mariam",30,Gender.FEMALE,"mariam@gmail.com"));
        people.add(new Person(counter.incrementAndGet(),"Ghady",24,Gender.MALE,"Ghady@gmail.com"));
    }

    public AtomicInteger getCounter() {
        return counter;
    }

    public  List<Person> getPeople() {
        return people;
    }
}
