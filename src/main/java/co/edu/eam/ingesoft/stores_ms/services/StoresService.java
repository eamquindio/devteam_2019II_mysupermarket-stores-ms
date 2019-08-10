package co.edu.eam.ingesoft.stores_ms.services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


<<<<<<< HEAD

import co.edu.eam.ingesoft.stores_ms.repository.PersonRepository;
=======
import co.edu.eam.ingesoft.stores_ms.repository.StoresRepository;
>>>>>>> [resolver #13] create stores

import co.edu.eam.ingesoft.stores_ms.repository.StoreRepository;
import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.model.Stores;



@Service
public class StoresService {

<<<<<<< HEAD



	

	

	
<<<<<<< HEAD
}
=======
=======
	/*
	 * Initialize the interface
	 */

	@Autowired
	private StoresRepository storesRepository;
	


	/*
	 * Calling method from interface to method
	 */

>>>>>>> [resolver #13] create stores
	public void createStores(Stores stores) {
		storesRepository.save(stores);
	} 

}
>>>>>>> [resolver #13] create stores
