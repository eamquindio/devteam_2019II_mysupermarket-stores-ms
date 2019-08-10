package co.edu.eam.ingesoft.stores_ms.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores_ms.repository.StoreRepository;

@Service
public class StoresService {
	
	@Autowired
	private StoreRepository storesRepository;
	
	

}
