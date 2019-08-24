package co.edu.eam.ingesoft.stores.services;
import java.util.List;

import javax.persistence.EntityExistsException;
import javax.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.repositories.StoresRepository;
/**
 * Bussiness class for Stores Entity.
 *
 * @author caferrerb
 *
 */
@Service
public class StoresService {
  /**
   * Stores repository.
   */
  @Autowired
  private StoresRepository storesRepository;
  /**
   * Create a stores.
   *
   * @param storesToCreate  to create.
   * @return Stores created
   */
  public Stores createStores(Stores  storesToCreate) {
    Stores store = find(storesToCreate.getId());

    if (store != null) {
      throw new EntityExistsException("person already exists");
    }

    return storesRepository.save(storesToCreate);
  }
  /**
   * Find a store.
   *
   * @param id to id the store
   * @return the store found
   */
  public Stores find(String id) {
    return storesRepository.findById(id).orElse(null);
  }

  /**
   * Update a store.
   *
   * @param store store to update.
   * @return store edited
   */
  public Stores update(Stores store) {
    Stores storeToUpdate = find(store.getId());

    if (storeToUpdate == null) {
      throw new EntityNotFoundException("store not exists");
    }

    return storesRepository.save(store);
  }
  /**
   * List all stores.
   *
   * @return list of all stores
   */
  public List<Stores> listAll() {
    return storesRepository.findAll();
  }
  /**
   * Delete a Store.
   *
   * @param id id to delete
   * @return store deleted
   */
  public Stores delete(String id) {
    Stores stores = find(id);
    if (stores == null) {
      throw new EntityNotFoundException("Store not exists");
    }
    storesRepository.deleteById(id);
    return stores;
  }
  /**
   * List stores by name.
   *
   * @param name name to looking for
   * @return list fo store with a name.
   */
  public List<Stores> findByName(String name) {
    return storesRepository.findByName(name);
  }
}
