package com.spring_boot.person;

import com.spring_boot.SortingOrder;
import com.spring_boot.exceptions.AlreadyExistException;
import com.spring_boot.exceptions.ResourceNotFoundException;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private  final FakePersonRepository repository;
    private final PersonRepository personRepository;

    public PersonService(FakePersonRepository repository, PersonRepository personRepository) {
        this.repository = repository;
        this.personRepository = personRepository;
    }

    public List<Person> personList(SortingOrder sortingOrder, Integer limit){
        return personRepository.findAll(Sort.by(Sort.Direction.valueOf(sortingOrder.name()),"id"));
    }


    public void DeletePerson(int id)
    {

        boolean exists = personRepository.existsById(id);
        if(!exists)
        {
            throw new ResourceNotFoundException("Person not found");
        }

        personRepository.deleteById(id);
    }



    public void AddPerson(NewPersonRequest person)
    {
        if(personRepository.existsByEmail(person.email()))
            throw new AlreadyExistException("Email already exist");
        personRepository.save(new Person(
                person.name(),
                person.age(),
                person.gender(),
                person.email()
        ));
    }
    public boolean existByEmail(String email)
    {
        return repository.getPeople().stream()
                .anyMatch(p->p.getEmail().equals(email));
    }


    public void UpdatePerson(Integer id,PersonUpdateRequest person)
    {
        Person p = personRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Person not found"));

        personRepository.save( new Person(
                p.getId(),
                person.name(),
                person.age(),
                p.getGender(),
                p.getEmail()));

    }



    public Person getPerson(int id)
    {
        return   personRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Person not found"));

    }
}
