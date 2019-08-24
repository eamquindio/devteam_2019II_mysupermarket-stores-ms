package co.edu.eam.ingesoft.stores.controllers;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.routes.Router;
import co.edu.eam.ingesoft.stores.services.StoresService;
/**
 * Stores controller.
 * @author caferrerb
 *
 */
@RestController
@RequestMapping("api/stores-ms/stores")
public class StoresController {
  /**
   * stores service.
   */
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
   * find a person.
   *
   * @param id id for store to find
   * @param response httpresponse
   * @return store with id
   */
  @GetMapping(value = Router.FIND_PERSON + "/{id}")
  public Stores find(@PathVariable String id, HttpServletResponse response) {
    Stores store = storesService.find(id);

    if (store == null) {
      response.setStatus(HttpStatus.NOT_FOUND.value());
    }

    return store;
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


  /**
   * find a person by name.
   *
   * @param name name person to find
   * @return list of store with a name
   */
  @GetMapping(value = "/find_by_name")
  public List<Stores> findByName(@RequestParam String name) {
    return storesService.findByName(name);
  }

}
