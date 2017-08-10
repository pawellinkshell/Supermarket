package pl.koszela.jan.persistence.dto.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.persistence.dto.SpecialPriceDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultSpecialPriceDTO implements SpecialPriceDTO {

  @SerializedName("id")
  private int id;
  @SerializedName("amount")
  private int amount;
  @SerializedName("price")
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

  @Override
  public String toString() {
    return "DefaultSpecialPriceDTO{" +
        "id=" + id +
        ", amount=" + amount +
        ", price=" + price +
        '}';
  }
}
