package pl.koszela.jan.layer.facade.dto.impl;

import java.io.Serializable;
import pl.koszela.jan.layer.facade.dto.PriceDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class StockPriceDTO implements PriceDTO, Serializable {

  private int id;
  private double price;
  private String currency;

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }

  @Override
  public String getCurrency() {
    return this.currency;
  }

  @Override
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "StockPriceDTO{" +
        "id=" + id +
        ", price=" + price +
        ", currency='" + currency + '\'' +
        '}';
  }
}
