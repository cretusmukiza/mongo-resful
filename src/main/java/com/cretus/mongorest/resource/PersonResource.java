package com.cretus.mongorest.resource;

import java.util.Date;
import java.util.List;
import java.util.Map;

import com.cretus.mongorest.entities.Person;
import com.cretus.mongorest.entities.PersonDALImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonResource {

    @Autowired
    PersonDALImpl personDALImpl;

    private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloperBlog");

    @PostMapping(value="/persons")
    public Person savePerson(@RequestBody Person person){
        return personDALImpl.savePerson(person);
    }

    @GetMapping(value="/persons")
    public List<Person> getAllPersons(){
        return personDALImpl.getAllPersons();
    }

    @GetMapping(path="/persons/{pageNumber}/{pageSize}")
    public List<Person> getAllPersonsPaginated(@PathVariable Map<String,String> pages){
        int pageNumber = Integer.valueOf(pages.get("pageNumber"));
        int pageSize = Integer.valueOf(pages.get("pageSize"));
        return personDALImpl.getAllPersonsPaginated(pageNumber, pageSize);
    }

    @GetMapping(value="/persons/name/{name}")
    public Person findOneByName(@PathVariable String name){
        return personDALImpl.findOneByName(name);
    }

    @GetMapping(value="/persons/all/{name}")
    public List<Person> findByName(@PathVariable String name){
        return personDALImpl.findByName(name);
    }

    @GetMapping(value="/persons/birth/{birthDate}")
    public List<Person> findByBirthDateAfter(@PathVariable Date date){
        return personDALImpl.findByBirthDateAfter(date);
    }

    @GetMapping(path="/persons/age/{lowerBound}/{upperBound}")
    public List<Person>  findByBirthDateRange(@PathVariable Map<String,String> bounds){
        int lowerBound = Integer.valueOf(bounds.get("lowerBound"));
        int upperBound = Integer.valueOf(bounds.get("upperBound"));
        return personDALImpl.findByAgeRange(lowerBound, upperBound);
    }

    @GetMapping(value="/persons/book/{bookName}")
    public List<Person> findByFavouriteBookName(@PathVariable String bookName){
        return personDALImpl.findByFavouriteBook(bookName);
    }

    @PatchMapping(value="/persons/age")
    public void  updateMultiplePersonAges(){
        personDALImpl.updateMultiplePersonAge();
    }

    @DeleteMapping(value="/persons/{id}")
    public void deletePerson(@PathVariable String id){
        personDALImpl.deletePerson(id);
    }






    
}
