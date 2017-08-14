package pl.koszela.jan.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class Product {

  @SerializedName("id")
  private int id;
  @SerializedName("name")
  private String name;
  @SerializedName("multipricing")
  private boolean multipricing;

  public Product(int id, String name, boolean multipricing) {
    this.id = id;
    this.name = name;
    this.multipricing = multipricing;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public boolean isMultipricing() {
    return multipricing;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMultipricing(boolean multipricing) {
    this.multipricing = multipricing;
  }

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", multipricing=" + multipricing +
        '}';
  }
}
