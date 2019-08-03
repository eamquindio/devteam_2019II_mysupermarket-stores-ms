package co.edu.eam.ingesoft.stores_ms.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import co.edu.eam.ingesoft.stores_ms.model.Stores;

@Repository
public interface StoresRepository extends CrudRepository<Stores, String> {

}
