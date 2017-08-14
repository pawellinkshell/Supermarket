package pl.koszela.jan.persistence.dto.impl;

import java.io.Serializable;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public class SpecialPriceDTO implements PriceDTO, Serializable {

  private int id;
  private int amount;
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

  public int getAmount() {
    return amount;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "SpecialPriceDTO{" +
        "id=" + id +
        ", amount=" + amount +
        ", price=" + price +
        ", currency='" + currency + '\'' +
        '}';
  }
}

