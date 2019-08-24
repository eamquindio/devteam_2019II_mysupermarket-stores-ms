package co.edu.eam.ingesoft.productms.test.controllers;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import static org.junit.Assert.assertFalse;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
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
  

  public static final String FIND_STORE = Router.STORES_PATH + Router.FIND_STORE;

  public static final String DELETE = Router.STORES_PATH + Router.DELETE_PERSON;

  @Autowired
  private StoresRepository storesRepository;

  @Before
  public void beforeEach() {
    storesRepository.deleteAll();
  }

  @Test
  public void del() throws Exception {
    storesRepository.saveAll(Lists.list(new Stores("1", "camilo",new Long(22),new Long(33),"prueba")));
    mockMvc.perform(delete(DELETE + "/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    boolean exits = storesRepository.findById(new String("1")).isPresent();
    assertFalse(exits);

  }

  @Test
  public void delNotExists() throws Exception {
    mockMvc.perform(delete(DELETE + "/1").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
  }

  @Test
  public void findById() throws Exception {
    storesRepository.saveAll(Lists.list(new Stores("123", "Store 1", new Long(1), new Long(2), "Description 1")));

    mockMvc.perform(get(FIND_STORE + "/123")).andExpect(status().isOk()).andExpect(jsonPath("$.name", is("Store 1")));
  }

  @Test
  public void findByIdNotFound() throws Exception {
    mockMvc.perform(get(FIND_STORE + "/123")).andExpect(status().isNotFound());
  }
}
