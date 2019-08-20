package co.edu.eam.ingesoft.stores.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import co.edu.eam.ingesoft.stores.model.Stores;

/**
  *Stores repository.
  *@author caferrerb
  *
  */
@Repository
public interface StoresRepository extends CrudRepository<Stores, String> {
  /**
	/**
   * Find all persons.
   * @return list or persons.
   */
  List<Stores> findAll();

  /**
   * Find all persons given a name.
   * @param name name to look for.
   * @return list or persons.
   */
  List<Stores> findByName(String name);
}
