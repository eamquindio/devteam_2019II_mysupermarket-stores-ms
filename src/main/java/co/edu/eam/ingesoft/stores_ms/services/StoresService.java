package co.edu.eam.ingesoft.stores_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



import co.edu.eam.ingesoft.stores_ms.repository.PersonRepository;
import co.edu.eam.ingesoft.stores_ms.repository.StoresRepository;

import co.edu.eam.ingesoft.stores_ms.model.Person;

import co.edu.eam.ingesoft.stores_ms.repository.StoresRepository;
import co.edu.eam.ingesoft.stores_ms.model.Stores;

@Service
public class StoresService {








	/*
	 * Initialize the interface
	 */

	@Autowired
	private StoresRepository storesRepository;

	/*
	 * Calling method from interface to method
	 */

	public void createStores(Stores stores) {
		storesRepository.save(stores);
	}

}
