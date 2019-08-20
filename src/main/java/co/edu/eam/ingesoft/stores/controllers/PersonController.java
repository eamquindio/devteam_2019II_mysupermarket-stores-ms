package co.edu.eam.ingesoft.stores.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import co.edu.eam.ingesoft.stores.model.Person;
import co.edu.eam.ingesoft.stores.services.PersonService;
/**
 * REst controller for person entity.
 *
 * @author caferrerb
 *
 */
@RestController
@RequestMapping("api/stores-ms/person")
public class PersonController {
  /**
   * person service.
   */
  @Autowired
  private PersonService personService;
  
}
