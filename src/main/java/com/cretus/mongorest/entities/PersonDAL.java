package com.cretus.mongorest.entities;

import java.util.Date;
import java.util.List;

public interface PersonDAL {
    Person savePerson(Person person);

    List<Person> getAllPersons();

    List<Person> getAllPersonsPaginated(int pageNumber, int pageSize);

    Person findOneByName(String name);

    List<Person> findByName(String name);

    List<Person> findByBirthDateAfter(Date date);

    List<Person> findByAgeRange(int lowerBound, int upperBound);

    List<Person> findByFavouriteBook(String favouriteBook);

    void updateMultiplePersonAge();

    Person updateOnePerson(Person person);

    void deletePerson(Person person);

}
