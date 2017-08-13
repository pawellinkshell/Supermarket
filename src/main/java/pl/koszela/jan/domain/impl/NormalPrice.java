package pl.koszela.jan.domain.impl;

import pl.koszela.jan.domain.Price;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public class NormalPrice implements Price {

  private int id;
  private double price;
  private String currency;

  public NormalPrice(int id, double price, String currency) {
    this.id = id;
    this.price = price;
    this.currency = currency;
  }

  public int getId() {
    return this.id;
  }

  public double getPrice() {
    return this.price;
  }

  public String getCurrency() {
    return this.currency;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }
}
