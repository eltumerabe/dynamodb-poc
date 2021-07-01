package com.tpconnects.dynamodbexample.repository;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMapper;
import com.tpconnects.dynamodbexample.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    @Autowired
    private DynamoDBMapper dynamoDBMapper;

    public Person save(Person person) {
        try {
            dynamoDBMapper.save(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return person;
    }

    public Person findPerson(String personId) {
        return dynamoDBMapper.load(Person.class, personId);
    }

    public String deltePerson(Person person) {
        try {
            dynamoDBMapper.delete(person);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "person deleted !";
    }
}
