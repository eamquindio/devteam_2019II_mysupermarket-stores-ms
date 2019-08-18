package co.edu.eam.ingesoft.stores.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.services.StoresService;

/**
 * Stores controller.
 * 
 * @author caferrerb
 *
 */
@RestController
@RequestMapping("api/stores-ms/stores")
public class StoresController {

	/**
	 * stores service.
	 */
	@Autowired
	private StoresService storesService;

	/**
	 * list all stores.
	 *
	 * @return list of all stores
	 */
	@GetMapping(value = "/all")
	public List<Stores> findAll() {
		return storesService.listAll();
	}

}
