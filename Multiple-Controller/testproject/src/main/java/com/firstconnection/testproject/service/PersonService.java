package com.firstconnection.testproject.service;

import com.firstconnection.testproject.model.Person;
import com.firstconnection.testproject.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }

    public Person savePerson(Person person) {
        return personRepository.save(person);
    }

    public Person getPersonById(Long id) {
        return personRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Person not found with ID: " + id));
    }

    public Person updatePerson(Long id, Person personDetails) {
        Person existingPerson = getPersonById(id);
        existingPerson.setName(personDetails.getName());
        existingPerson.setAge(personDetails.getAge());
        // Add more fields to update as needed
        return personRepository.save(existingPerson);
    }

    public void deletePerson(Long id) {
        Person existingPerson = getPersonById(id);
        personRepository.delete(existingPerson);
    }
}
