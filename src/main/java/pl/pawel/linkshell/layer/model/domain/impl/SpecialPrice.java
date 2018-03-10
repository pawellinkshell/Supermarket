package pl.pawel.linkshell.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;
import pl.pawel.linkshell.layer.model.domain.Price;

/**
 * Created on 11.08.2017.
 *
 */
public class SpecialPrice implements Price {

  @SerializedName("id")
  private int id;
  @SerializedName("amount")
  private int amount;
  @SerializedName("unit")
  private double unit;
  @SerializedName("currency")
  private String currency;

  public SpecialPrice(int id, int amount, double unit, String currency) {
    this.id = id;
    this.amount = amount;
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

  public int getAmount() {
    return this.amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "SpecialPrice{" +
        "id=" + id +
        ", amount=" + amount +
        ", unit=" + unit +
        ", currency='" + currency + '\'' +
        '}';
  }
}
