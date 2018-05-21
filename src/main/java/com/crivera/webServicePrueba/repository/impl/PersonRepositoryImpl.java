package com.crivera.webServicePrueba.repository.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.crivera.webServicePrueba.modelDao.PersonDao;
import com.crivera.webServicePrueba.repository.PersonRepository;

@Repository
public class PersonRepositoryImpl implements PersonRepository {

	@PersistenceContext
	private static EntityManager entityManager;

	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("Persistence");

	@Override
	public void insertPerson(PersonDao person) {
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		entityManager.persist(person);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	@Override
	public List<PersonDao> findAllPersons() {
		entityManager = emf.createEntityManager();
		ArrayList<PersonDao> persons = (ArrayList<PersonDao>) entityManager.createQuery("FROM PersonDao")
				.getResultList();
		return persons;
	}

	@Override
	public PersonDao findPersonById(Integer id) {
		Integer idPerson = id;
		entityManager = emf.createEntityManager();
		entityManager.getTransaction().begin();
		PersonDao person = entityManager.find(PersonDao.class, idPerson.toString());
		entityManager.getTransaction().commit();
		entityManager.close();
		return person;
	}

}
