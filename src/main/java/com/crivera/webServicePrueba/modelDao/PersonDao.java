package com.crivera.webServicePrueba.modelDao;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.crivera.webServicePrueba.model.Person;

@Entity
@Table(name = "personas")
public class PersonDao implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id")
	String id;

	@Column(name = "apellido")
	String nombre;

	@Column(name = "nombre")
	String apellido;

	public PersonDao(Person person) {
		this.id = person.getId();
		this.nombre = person.getNombre();
		this.apellido = person.getApellido();
	}

	public PersonDao(String id, String nombre, String apellido) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public PersonDao() {

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

	public void setId(String id) {
		this.id = id;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	@Override
	public String toString() {
		return "personDao [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

}
