package com.crivera.webServicePrueba.repository;

import java.util.List;

import com.crivera.webServicePrueba.modelDao.PersonDao;

public interface PersonRepository {

	void insertPerson(PersonDao person);

	List<PersonDao> findAllPersons();

	PersonDao findPersonById(Integer id);

	public void deletePersonById(PersonDao person);

}
