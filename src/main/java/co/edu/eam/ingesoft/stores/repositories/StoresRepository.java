package co.edu.eam.ingesoft.stores.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.eam.ingesoft.stores.model.Stores;

/**
 * Product repository.
 * @author caferrerb
 *
 */
@Repository
public interface StoresRepository extends CrudRepository<Stores, String> {
}
