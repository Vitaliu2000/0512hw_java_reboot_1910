package ru.itvitality.sbrf.cu.sfc.dao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.itvitality.sbrf.cu.sfc.domain.Person;

@Service
public class PersonDaoSimple implements PersonDao {
    @Value("${default.age}")
    private Integer age;

    public Person findByName(String name) {
        return new Person(name, age);
    }
}
