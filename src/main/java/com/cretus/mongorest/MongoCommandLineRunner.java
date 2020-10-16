package com.cretus.mongorest;

import java.util.Arrays;
import java.util.Date;

import com.cretus.mongorest.entities.Person;
import com.cretus.mongorest.entities.PersonDALImpl;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
@Component
public class MongoCommandLineRunner implements CommandLineRunner {
    private static final Logger LOG = LoggerFactory.getLogger("AppsDeveloperBlog");
    private final PersonDALImpl personDALImpl;
    @Autowired
    public MongoCommandLineRunner(PersonDALImpl personDALImpl) {
       this.personDALImpl = personDALImpl;
    }

    @Override
    public void run(String... args) {
        personDALImpl.savePerson(new Person(
            "Shubham", Arrays.asList("Harry potter", "Waking Up"), new Date(769372200000L)));
       
       personDALImpl.savePerson(new Person(
             "Sergey", Arrays.asList("Startup Guides", "Java"), new Date(664309800000L)));
       personDALImpl.savePerson(new Person(
             "David", Arrays.asList("Harry potter", "Success"), new Date(695845800000L)));
       personDALImpl.savePerson(new Person(
             "Ivan", Arrays.asList("Secrets of Butene", "Meeting Success"), new Date(569615400000L)));
       personDALImpl.savePerson(new Person(
             "Sergey", Arrays.asList("Harry potter", "Startup Guides"), new Date(348777000000L)));
       LOG.info("Getting all data from MongoDB: \n{}",
             personDALImpl.getAllPersons());
       LOG.info("Getting paginated data from MongoDB: \n{}",
             personDALImpl.getAllPersonsPaginated(0, 2));
       LOG.info("Getting person By name 'Sergey': {}",
             personDALImpl.findByName("Sergey"));
       LOG.info("Getting all person By name 'Sergey': {}",
             personDALImpl.findOneByName("Sergey"));
       LOG.info("Getting people between age 22 & 26: {}",
             personDALImpl.findByAgeRange(22, 26));
    }
  }
