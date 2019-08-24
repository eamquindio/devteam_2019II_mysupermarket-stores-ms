package co.edu.eam.ingesoft.productms.test.controllers;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.junit.Assert.assertFalse;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
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

  public static final String EDIT = Router.STORES_PATH + Router.EDIT_STORE;
  
  public static final String SAVE = Router.STORES_PATH + Router.CREATE_STORE;

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
  public void edit() throws Exception {
    storesRepository.saveAll(Lists.list(new Stores("1", "almacen", new Long(2),new Long(2), "prueba")));

    String content = "{\"id\":\"1\",\"name\":\"almacen a\",\"lat\":3,\"lng\":3,\"dscripcion\":\"prueba 2\" }";

    mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    Stores storeToAssert = storesRepository.findById(new String("1")).get();
    assertEquals("almacen a", storeToAssert.getName());
    assertEquals(new Long(3), storeToAssert.getLat());
    assertEquals(new Long(3), storeToAssert.getLng());
    assertEquals("prueba 2", storeToAssert.getDscripcion());

  }

  @Test
  public void editNotExists() throws Exception {
	String content = "{\"id\":\"3\",\"name\":\"almacen\",\"lat\":2,\"lng\":2,\"dscripcion\":\"prueba\" }";

    mockMvc.perform(put(EDIT).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNotFound());
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
  
  @Test
  public void save() throws Exception {
    String content = "{\"id\":\"1\",\"nombre\":\"olimpica\", \"lat\":23 , \"lng\":50 , \"dscripcion\":\"promociones\"}";
    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());

    Stores storeToAssert = storesRepository.findById(new String("1")).get();
    assertEquals("1", storeToAssert.getId());
    assertEquals("olimpica", storeToAssert.getName());
    assertEquals(new Long (23), storeToAssert.getLng());
    assertEquals(new Long (40), storeToAssert.getLat());
    assertEquals("Promociones", storeToAssert.getDscripcion());

  }
  @Test
  public void saveAlreadyExists() throws Exception {
    storesRepository.saveAll(Lists.list(new Stores("1", "camilo" , new Long(23) , new Long(50) , "promociones"), new Stores("2", "exito" , new Long(60) , new Long (80) , "Calidad")));
    String content = "{\"id\":\"1\",\"nombre\":\"olimpica\", \"lat\":23 , \"lng\":50 , \"dscripcion\":\"promociones\"}";
    
    mockMvc.perform(post(SAVE).content(content).contentType(MediaType.APPLICATION_JSON)).andExpect(status().is(409));
  }

  }

