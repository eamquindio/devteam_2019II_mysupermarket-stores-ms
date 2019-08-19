package co.edu.eam.ingesoft.stores.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.eam.ingesoft.stores.model.Stores;

/**
 * Product repository.
 *
 * @author caferrerb
 *
 */
@Repository
public interface StoresRepository extends CrudRepository<Stores, String> {
  /**
   * Find all stores given a id.
   * @param id id to look for.
   * @return list or stores.
   */
  List<Stores> findById(Integer id);
}
