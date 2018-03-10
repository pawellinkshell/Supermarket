package pl.pawel.linkshell.layer.facade.dto.impl;

import java.io.Serializable;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;

/**
 * Created on 09.08.2017.
 *
 */
public class DefaultItemDTO implements ItemDTO, Serializable {

  private int id;
  private String item;

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getItem() {
    return this.item;
  }

  @Override
  public void setItem(String item) {
    this.item = item;
  }

  @Override
  public String toString() {
    return "DefaultItemDTO{" +
        "id=" + id +
        ", item='" + item + '\'' +
        '}';
  }
}
