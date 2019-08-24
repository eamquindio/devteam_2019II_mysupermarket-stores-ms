package co.edu.eam.ingesoft.productms.test.controllers;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import co.edu.eam.ingesoft.stores.Application;
import co.edu.eam.ingesoft.stores.model.Stores;
import co.edu.eam.ingesoft.stores.repositories.StoresRepository;
import co.edu.eam.ingesoft.stores.routes.Router;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ContextConfiguration(classes = { Application.class })
public class StoresControllerTest {

  @Autowired
  private MockMvc mockMvc;

  public static final String FIND_BY_NAME = Router.STORES_PATH + Router.FIND_BY_NAME;
  
  @Autowired
  private StoresRepository storesRepository;
  
  
  @Before
  public void beforeEach() {
    storesRepository.deleteAll();
  }
  

  @Test
  public void test() {
    assertTrue(true);
  }
  
  
  public void listByNameStore() throws Exception {
    mockMvc.perform(get(FIND_BY_NAME + "?name=tienda1")).andExpect(status().isNoContent());
  }
  
  @Test
  public void listByNameEmptyTest() throws Exception {

    storesRepository.saveAll(Lists.list(new Stores("1", "tienda1",new Long(22),new Long(12),"tienda")));

    mockMvc.perform(get(FIND_BY_NAME + "?name=tienda1")).andExpect(status().isOk()).andExpect(jsonPath("$", hasSize(1)))
        .andExpect(jsonPath("$[0].name", is("tienda1")));
  }
}
