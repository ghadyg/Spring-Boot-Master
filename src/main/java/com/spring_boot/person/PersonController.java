package com.spring_boot.person;

import com.spring_boot.SortingOrder;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import jakarta.validation.constraints.Positive;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/person")
public class PersonController {

    private final PersonService personService;
    private final Validator validator ;

    public PersonController(PersonService personService, Validator validator) {

        this.personService = personService;
        this.validator = validator;
    }

    @GetMapping
    public List<Person> personList(
            @RequestParam(value = "sort",required = false,defaultValue = "DESC") SortingOrder sortingOrder,
            @RequestParam(value = "limit" ,required = false,defaultValue = "10") Integer limit
    ){
        return personService.personList(sortingOrder,limit);
    }

    @DeleteMapping("{id}")
    public void DeletePerson(@Valid @Positive @PathVariable("id") int id)
    {
        personService.DeletePerson(id);
    }

    @PostMapping
    public void AddPerson(@Valid @RequestBody NewPersonRequest person)
    {
        /*Set<ConstraintViolation<NewPersonRequest>> validate = validator.validate(person);
        validate.forEach(error ->System.out.println(error.getMessage()));
        if(!validate.isEmpty())
            throw new ConstraintViolationException(validate);*/
        personService.AddPerson(person);
    }

    @PutMapping("{id}")
    public void UpdatePerson(
            @Valid @Positive @PathVariable("id") Integer id,
            @Valid @RequestBody PersonUpdateRequest person)
    {
        personService.UpdatePerson(id,person);
    }


    @GetMapping("{id}")
    public Person getPerson(
            @PathVariable("id") int id

    )
    {
        return personService.getPerson(id);
    }
}
