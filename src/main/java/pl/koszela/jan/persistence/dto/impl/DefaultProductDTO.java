package pl.koszela.jan.persistence.dto.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductDTO implements ProductDTO {

  @SerializedName("id")
  private int id;
  @SerializedName("item")
  private String item;
  @SerializedName("unitPrice")
  private double unitPrice;
  @SerializedName("currency")
  private String currency;
  @SerializedName("multipricing")
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

  @Override
  public String toString() {
    return "\nDefaultProductDTO{" +
        "id=" + id +
        ", item='" + item + '\'' +
        ", unitPrice=" + unitPrice +
        ", currency='" + currency + '\'' +
        ", multipricing=" + multipricing +
        '}';
  }
}
