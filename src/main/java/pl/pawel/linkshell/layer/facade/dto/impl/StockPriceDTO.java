package pl.pawel.linkshell.layer.facade.dto.impl;

import java.io.Serializable;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;

/**
 * Created on 10.08.2017.
 *
 */
public class StockPriceDTO implements PriceDTO, Serializable {

  private int id;
  private double unit;
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
  public double getUnit() {
    return this.unit;
  }

  @Override
  public void setUnit(double price) {
    this.unit = price;
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
        ", unit=" + unit +
        ", currency='" + currency + '\'' +
        '}';
  }
}
