package pl.koszela.jan.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.layer.model.domain.Price;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public class NormalPrice implements Price {

  @SerializedName("id")
  private int id;
  @SerializedName("unit")
  private double unit;
  @SerializedName("currency")
  private String currency;

  public NormalPrice(int id, double unit, String currency) {
    this.id = id;
    this.unit = unit;
    this.currency = currency;
  }

  public int getId() {
    return this.id;
  }

  public double getUnit() {
    return this.unit;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setUnit(double price) {
    this.unit = price;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "NormalPrice{" +
        "id=" + id +
        ", unit=" + unit +
        ", currency='" + currency + '\'' +
        '}';
  }
}
