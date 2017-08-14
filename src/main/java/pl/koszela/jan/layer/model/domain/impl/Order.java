package pl.koszela.jan.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;
import pl.koszela.jan.layer.model.domain.Price;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public class Order {

  @SerializedName("item")
  private Item item;
  @SerializedName("stockPrice")
  private Price stockPrice;
  @SerializedName("quantity")
  private int quantity;
  @SerializedName("totalPrice")
  private Price totalPrice;
  @SerializedName("specialOffer")
  private boolean specialOffer;

  public Order(Item item, Price stockPrice, int quantity,
      Price totalPrice, boolean specialOffer) {
    this.item = item;
    this.stockPrice = stockPrice;
    this.quantity = quantity;
    this.totalPrice = totalPrice;
    this.specialOffer = specialOffer;
  }

  public Item getItem() {
    return item;
  }

  public void setItem(Item item) {
    this.item = item;
  }

  public Price getStockPrice() {
    return stockPrice;
  }

  public void setStockPrice(Price stockPrice) {
    this.stockPrice = stockPrice;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  public Price getTotalPrice() {
    return totalPrice;
  }

  public void setTotalPrice(Price totalPrice) {
    this.totalPrice = totalPrice;
  }

  public boolean isSpecialOffer() {
    return specialOffer;
  }

  public void setSpecialOffer(boolean specialOffer) {
    this.specialOffer = specialOffer;
  }

  @Override
  public String toString() {
    return "Order{" +
        "item=" + item +
        ", stockPrice=" + stockPrice +
        ", quantity=" + quantity +
        ", totalPrice=" + totalPrice +
        ", specialOffer=" + specialOffer +
        '}';
  }
}
