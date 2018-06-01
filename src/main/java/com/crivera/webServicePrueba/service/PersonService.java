package com.crivera.webServicePrueba.service;

import java.util.List;

import com.crivera.webServicePrueba.model.Person;
import com.crivera.webServicePrueba.modelDao.PersonDao;

public interface PersonService {
	void insertPerson(Person person);

	List<PersonDao> findAllPersons();

	Person findPersonById(Integer id);
	
	void deletePersonById(Integer id);
}
