package pl.koszela.jan.layer.facade.dto.impl;

import java.io.Serializable;
import pl.koszela.jan.layer.facade.dto.ProductDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductDTO implements ProductDTO, Serializable {

  private int id;
  private String item;
  private boolean multipricing;

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
  public boolean isMultipricing() {
    return this.multipricing;
  }

  @Override
  public void setMultipricing(boolean multipricing) {
    this.multipricing = multipricing;
  }

  @Override
  public String toString() {
    return "DefaultProductDTO{" +
        "id=" + id +
        ", item='" + item + '\'' +
        ", multipricing=" + multipricing +
        '}';
  }
}
