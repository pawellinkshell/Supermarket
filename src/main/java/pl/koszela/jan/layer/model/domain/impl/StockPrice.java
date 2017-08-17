package pl.koszela.jan.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.layer.model.domain.Price;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public class StockPrice implements Price {

  @SerializedName("id")
  private int id;
  @SerializedName("unit")
  private double unit;
  @SerializedName("currency")
  private String currency;

  public StockPrice(int id, double unit, String currency) {
    this.id = id;
    this.unit = unit;
    this.currency = currency;
  }

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public double getUnit() {
    return this.unit;
  }

  @Override
  public String getCurrency() {
    return this.currency;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public void setUnit(double price) {
    this.unit = price;
  }

  @Override
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "StockPrice{" +
        "id=" + id +
        ", unit=" + unit +
        ", currency='" + currency + '\'' +
        '}';
  }
}
