package co.edu.eam.ingesoft.stores_ms.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores_ms.model.Stores;
import co.edu.eam.ingesoft.stores_ms.services.StoreService;

@RestController
@RequestMapping("api/stores-ms/stores")

public class StoresController {
	
	@Autowired
	private StoreService storeService;
	
	@GetMapping(value="/{id}")
	public Stores find(@PathVariable String id) {
		return storeService.find(id);
	}

}
