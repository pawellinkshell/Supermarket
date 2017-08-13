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

  NormalPrice(int id, double price, String currency) {
    this.id = id;
    this.price = price;
    this.currency = currency;
  }

  public static NormalPriceBuilder builder() {
    return new NormalPriceBuilder();
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

  public String toString() {
    return "pl.koszela.jan.domain.impl.NormalPrice(id=" + this.getId() + ", price=" + this
        .getPrice() + ", currency=" + this.getCurrency() + ")";
  }

  public static class NormalPriceBuilder {

    private int id;
    private double price;
    private String currency;

    NormalPriceBuilder() {
    }

    public NormalPrice.NormalPriceBuilder id(int id) {
      this.id = id;
      return this;
    }

    public NormalPrice.NormalPriceBuilder price(double price) {
      this.price = price;
      return this;
    }

    public NormalPrice.NormalPriceBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public NormalPrice build() {
      return new NormalPrice(id, price, currency);
    }

    public String toString() {
      return "pl.koszela.jan.domain.impl.NormalPrice.NormalPriceBuilder(id=" + this.id + ", price="
          + this.price + ", currency=" + this.currency + ")";
    }
  }
}
