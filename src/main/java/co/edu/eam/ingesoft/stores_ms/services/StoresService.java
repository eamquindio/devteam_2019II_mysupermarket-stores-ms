package co.edu.eam.ingesoft.stores_ms.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD

import co.edu.eam.ingesoft.stores_ms.repository.PersonRepository;

@Service
public class StoresService {
=======
import co.edu.eam.ingesoft.stores_ms.model.Stores;
import co.edu.eam.ingesoft.stores_ms.repository.StoreRepository;

@Service
public class StoresService {
	
	@Autowired
	private StoreRepository storesRepository;

	public static List<Stores> findByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

>>>>>>> [resolves#8]list_store_by_name


}