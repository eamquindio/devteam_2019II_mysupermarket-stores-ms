package co.edu.eam.ingesoft.stores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	 * Edit a store.
	 *
	 * @param store store to edit
	 */
	@PutMapping(value = "/")
	public void edit(@RequestBody Stores store) {
		storesService.update(store);
	}
}
