package com.crivera.webServicePrueba.controller;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.crivera.webServicePrueba.modelDao.PersonDao;

public class TestMain {
	private static EntityManager manager;
	private static EntityManagerFactory emf;

	public static void main(String[] args) {
		emf = Persistence.createEntityManagerFactory("Persistence");
		manager = emf.createEntityManager();
		
		ArrayList<PersonDao> persons =(ArrayList<PersonDao>) manager.createQuery("from PersonDao").getResultList();
	System.out.println(persons.size());
	}

}
