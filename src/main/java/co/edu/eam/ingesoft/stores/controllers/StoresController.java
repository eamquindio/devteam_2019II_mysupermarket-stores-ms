package co.edu.eam.ingesoft.stores.controllers;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.services.StoresService;

/**
 * Stores controller.
 * @author caferrerb
 *
 */
@RestController
@RequestMapping("api/stores-ms/stores")
public class StoresController{
  /**
   * stores service.
   */
  @Autowired
  private StoresService storesService;

  /**
   * create a stores operation.
   *
   * @param store stores to create
   */
  @PostMapping(value = "/")
  public void create(@RequestBody Stores store) {
    storesService.createStores(store);
  }
  
  /**
   * find a store.
   *
   * @param id id for s store find
   * @return store with id
   */

  @GetMapping(value = "/{id}")
  public Stores find(@PathVariable String id) {
    return storesService.find(id);
  }

  /**
  * Edit a store.
  *
  * @param store store to edit
  */
  @PutMapping(value = "/")
  public void edit(@RequestBody Stores store) {
    storesService.update(store);
  }
  /**
  * list all stores.
  *
  * @return list of all stores
  */
  @GetMapping(value = "/all")
  public List<Stores> findAll() {
    return storesService.listAll();
  }
  /**
  * Delete a person.
  *
  * @param id person to delete
  */
  @DeleteMapping(value = "/{id}")
  public void delete(@PathVariable String id) {
    storesService.delete(id);
  }

}
