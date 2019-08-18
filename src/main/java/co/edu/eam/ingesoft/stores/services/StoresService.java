package co.edu.eam.ingesoft.stores.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.repositories.StoresRepository;

/**
 * Bussiness class for product Entity. *
 * @author caferrerb
 *
 */
@Service
public class StoresService {

/**
	 * product repository.
	 */
	@Autowired
	private StoresRepository storesRepository;

	/**
	 * List all stores.
	 *
	 * @return list of all stores
	 */
	public List<Stores> listAll() {
		return storesRepository.findAll();
	}
}