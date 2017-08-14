package pl.koszela.jan.domain.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.domain.Price;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
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

  public int getId() {
    return this.id;
  }

  public int getAmount() {
    return this.amount;
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

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setUnit(double price) {
    this.unit = price;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
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
