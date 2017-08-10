package pl.koszela.jan.persistence.dto.impl;

import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductDTO implements ProductDTO {

  private int id;
  private String item;
  private double unitPrice;
  private String currency;
  private boolean multipricing;

  @Override
  public int getId() {
    return this.id;
  }

  @Override
  public void setId(int id) {
    this.id = id;
  }

  @Override
  public String getItem() {
    return this.item;
  }

  @Override
  public void setItem(String item) {
    this.item = item;
  }

  @Override
  public double getUnitPrice() {
    return this.unitPrice;
  }

  @Override
  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
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
  public boolean isMultipricing() {
    return this.multipricing;
  }

  @Override
  public void setMultipricing(boolean multipricing) {
    this.multipricing = multipricing;
  }
}
