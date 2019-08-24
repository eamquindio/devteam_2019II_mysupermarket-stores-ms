package co.edu.eam.ingesoft.stores.routes;

/**
 * Class to define the service's routes.
 *
 * @author caferrerb
 *
 */
public class Router {

  /**
   * Base path of this api.
   */
  public static final String BASE_PATH = "/api/stores-ms";

  /**
   * person uri.
   */
  public static final String PERSON_PATH = BASE_PATH + "/persons";
  /**
   * create person uri.
   */
  public static final String CREATE_PERSON = "/";

  /**
   * find person uri.
   */
  public static final String FIND_PERSON = "/";

  /**
   * find person uri.
   */
  public static final String DELETE_PERSON = "/";

  /**
   * Edit person uri.
   */
  public static final String EDIT_PERSON = "/";

  /**
   * find by name persons uri.
   */
  public static final String FIND_BY_NAME = "/find_by_name";

  /**
   * find all person uri.
   */
  public static final String FIND_ALL = "/all";
  /**
   * find store uri.
   */
  public static final String FIND_STORE = "/";

  /**
   * stores uri.
   */
  public static final String STORES_PATH = BASE_PATH + "/stores";
  /**
   * Delete store uri.
   */
  public static final String DELETE_STORE = "/";

  /**
   * Edit stores uri.
   */
  public static final String EDIT_STORE = "/";
  /**
   * find all stores uri.
   */
  public static final String FIND_ALL_STORES = "/all";

}
