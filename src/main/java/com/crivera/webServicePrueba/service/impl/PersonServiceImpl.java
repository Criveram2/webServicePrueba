package com.crivera.webServicePrueba.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crivera.webServicePrueba.model.Person;
import com.crivera.webServicePrueba.modelDao.PersonDao;
import com.crivera.webServicePrueba.repository.PersonRepository;
import com.crivera.webServicePrueba.service.PersonService;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	private PersonRepository personRepository;

	@Override
	public void insertPerson(Person person) {
		PersonDao personDao = new PersonDao(person);
		personRepository.insertPerson(personDao);

	}

	@Override
	public List<PersonDao> findAllPersons() {
		return personRepository.findAllPersons();
	}

	@Override
	public Person findPersonById(Integer id) {
		PersonDao personDao = personRepository.findPersonById(id);
		Person person = new Person(personDao);
		return person;
	}

}
