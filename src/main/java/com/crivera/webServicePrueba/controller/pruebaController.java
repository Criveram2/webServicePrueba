package com.crivera.webServicePrueba.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.crivera.webServicePrueba.model.Person;
import com.crivera.webServicePrueba.modelDao.PersonDao;
import com.crivera.webServicePrueba.service.PersonService;
import com.google.gson.Gson;

@RestController
public class pruebaController {

	private static final Logger log = LoggerFactory.getLogger(pruebaController.class);

	@RequestMapping(value = "/holaMundo", produces = { "application/json" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> holaMundo(@RequestParam("ipAddress") String ipAddress) {
		log.info("ingreso a holaMundo");
		return new ResponseEntity<String>(ipAddress, HttpStatus.OK);
	}

	@Autowired
	private PersonService personManager;

	@RequestMapping(value = "/createPerson", consumes = { "application/json" }, produces = {
			"application/json" }, method = RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> createPerson(@RequestBody String body) {
		System.out.println("create");
		String json = body;
		Person person = new Gson().fromJson(json, Person.class);
		System.out.println(person.toString());
		personManager.insertPerson(person);
		String representacionJSON = new Gson().toJson(person);
		return new ResponseEntity<String>(representacionJSON, HttpStatus.OK);
	}

	@RequestMapping(value = "/findAllPerson", produces = { "application/json" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findAllPerson() {
		System.out.println("find all");
		List<PersonDao> persons = personManager.findAllPersons();
		String jsonResponde = new Gson().toJson(persons);
		return new ResponseEntity<String>(jsonResponde, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/Person/{personId}", produces = { "application/json" }, method = RequestMethod.GET)
	@ResponseBody
	public ResponseEntity<String> findPersonById(@PathVariable Integer personId) {
		System.out.println("findPersonById");
		Person person =personManager.findPersonById(personId);
		String representacionJSON = new Gson().toJson(person);
		return new ResponseEntity<String>(representacionJSON, HttpStatus.OK);
	}
	
	 @RequestMapping(value = "/Person/{personId}", method = RequestMethod.DELETE)
	    public ResponseEntity removeEventById(@PathVariable Integer personId){
	        return new ResponseEntity<>(HttpStatus.OK);
	    }
	 

}
