package co.edu.eam.ingesoft.stores.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Class to model a store.
 *
 * @author caferrerb
 *
 */
@Entity
public class Stores implements Serializable {

  /**
   * Id.
   */
  @Id
  private String id;

  /**
   * Store`s name.
   */
  private String name;

  /**
   * Store`s lat.
   */
  private Long lat;

  /**
   * Store`s longitud.
   */
  private Long lng;

  /**
   * Store`s description.
   */
  private String dscripcion;

  /**
   * @return the id
   */
  public final String getId() {
    return id;
  }

  /**
   * @param id the id to set
   */
  public final void setId(String id) {
    this.id = id;
  }

  /**
   * @return the name
   */
  public final String getName() {
    return name;
  }

  /**
   * @param name the name to set
   */
  public final void setName(String name) {
    this.name = name;
  }

  /**
   * @return the lat
   */
  public final Long getLat() {
    return lat;
  }

  /**
   * @param lat the lat to set
   */
  public final void setLat(Long lat) {
    this.lat = lat;
  }

  /**
   * @return the lng
   */
  public final Long getLng() {
    return lng;
  }

  /**
   * @param lng the lng to set
   */
  public final void setLng(Long lng) {
    this.lng = lng;
  }

  /**
   * @return the dscripcion
   */
  public final String getDscripcion() {
    return dscripcion;
  }

  /**
   * @param dscripcion the dscripcion to set
   */
  public final void setDscripcion(String dscripcion) {
    this.dscripcion = dscripcion;
  }

}
