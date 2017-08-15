package pl.koszela.jan.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class Item implements Comparable<Item>{

  @SerializedName("id")
  private int id;
  @SerializedName("name")
  private String name;

  public Item(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return "Item{" +
        "id=" + id +
        ", name='" + name + '\'' +
        '}';
  }

  @Override
  public int compareTo(Item o) {
    if (this.getId() == o.getId()) {
      return 0;
    } else if (this.getId() > o.getId()) {
      return 1;
    } else {
      return -1;
    }
  }
}
