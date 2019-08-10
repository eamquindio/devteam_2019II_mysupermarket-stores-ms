package co.edu.eam.ingesoft.stores_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.model.Stores;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.model.Stores;
import co.edu.eam.ingesoft.stores_ms.services.PersonService;
import co.edu.eam.ingesoft.stores_ms.services.StoreService;
import co.edu.eam.ingesoft.stores_ms.services.PersonService;
import co.edu.eam.ingesoft.stores_ms.services.StoresService;

@RestController
@RequestMapping("api/stores-ms/stores")

public class StoresController {

	@Autowired

	private StoreService storeService;

	@GetMapping(value = "/{id}")
	public Stores find(@PathVariable String id) {
		return storeService.find(id);
	}

	@Autowired
	private StoreService storesservice;

	// delete method that asks for id as variable
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable String id) {
		storeService.delete(id);
	}
	
	@PostMapping(value = "/")
	public void createStore(@RequestBody Stores stores) {
		storeService.createStores(stores);

	}

}
