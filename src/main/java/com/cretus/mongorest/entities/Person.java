package com.cretus.mongorest.entities;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import static java.util.Calendar.YEAR;
import static java.util.Calendar.MONTH;


@Document
public class Person {

    @Id
    private String personId;
    private String name;
    private long age;
    private List<String> favouriteBooks;
    private Date dateOfBirth;

    public Person(String name, List<String> favouriteBooks, Date dateOfBirth) {
        this.name = name;
        this.age = getDiffYears(dateOfBirth, new Date());;
        this.favouriteBooks = favouriteBooks;
        this.dateOfBirth = dateOfBirth;
    }
    private Calendar getCalendar(Date date){
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar;
    }
    
    private int getDiffYears(Date first,Date last){
        Calendar firstDate = getCalendar(first);
        Calendar lastDate = getCalendar(last);
        int diff = lastDate.get(YEAR) - firstDate.get(YEAR);
        if(firstDate.get(MONTH) > lastDate.get(MONTH)){
            diff--;
        }
        return diff;
    }
    

    @Override
    public String toString() {
        return "Person [age=" + age + ", dateOfBirth=" + dateOfBirth + ", favouriteBooks=" + favouriteBooks + ", name="
                + name + ", personId=" + personId + "]";
    }

    public String getPersonId() {
        return personId;
    }

    public void setPersonId(String personId) {
        this.personId = personId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public List<String> getFavouriteBooks() {
        return favouriteBooks;
    }

    public void setFavouriteBooks(List<String> favouriteBooks) {
        this.favouriteBooks = favouriteBooks;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

   

}
