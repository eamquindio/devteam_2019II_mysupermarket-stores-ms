package co.edu.eam.ingesoft.stores_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores_ms.model.Person;
import co.edu.eam.ingesoft.stores_ms.model.Stores;
import co.edu.eam.ingesoft.stores_ms.repository.StoresRepository;

@Service
public class StoreService {

	@Autowired
	private StoresRepository storeRepository;

	public Stores find(String id) {
		return storeRepository.findById(id).get();
	}

	// interface call the method
	public void delete(String id) {
		storeRepository.deleteById(id);
	}

	public void createStores(Stores stores) {
		storeRepository.save(stores);
	}
}
