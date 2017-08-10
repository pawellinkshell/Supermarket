package pl.koszela.jan.persistence.dto.impl;

import pl.koszela.jan.persistence.dto.SpecialPriceDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultSpecialPriceDTO implements SpecialPriceDTO {
  private int id;
  private int amount;
  private double price;

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public int getAmount() {
    return this.amount;
  }

  @Override
  public void setAmount(int amount) {
    this.amount = amount;
  }

  @Override
  public double getPrice() {
    return this.price;
  }

  @Override
  public void setPrice(double price) {
    this.price = price;
  }
}
