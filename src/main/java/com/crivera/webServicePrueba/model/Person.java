package com.crivera.webServicePrueba.model;

import com.crivera.webServicePrueba.modelDao.PersonDao;

public final class Person {
	private final String id;
	private final String nombre;
	private final String apellido;

	public Person(String id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Person(PersonDao personDao) {
		this.id = personDao.getId();
		this.nombre = personDao.getNombre();
		this.apellido = personDao.getApellido();
	}
	
	public String getId() {
		return id;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	@Override
	public String toString() {
		return "Persona [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
