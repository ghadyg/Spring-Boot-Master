package com.spring_boot.person;

import com.spring_boot.SortingOrder;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.domain.Sort;


@SpringBootTest
class PersonServiceTest {

    @Autowired
    private PersonService personService;
    @MockBean
    private PersonRepository personRepository;
    @MockBean
    private FakePersonRepository repository;

    @Test
    void canGetPeople()
    {
        SortingOrder sortingOrder = SortingOrder.ASC;
        personService.personList(sortingOrder,10);

        ArgumentCaptor<Sort>argumentCaptor = ArgumentCaptor.forClass(Sort.class);
        Mockito.verify(personRepository).findAll(argumentCaptor.capture());
        Assertions.assertThat(argumentCaptor.getValue())
                .isEqualTo(Sort.by(Sort.Direction.valueOf(sortingOrder.name()),"id"));
    }


}