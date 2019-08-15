package co.edu.eam.ingesoft.stores.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
  @Autowired
  private StoresService storesService;

}
