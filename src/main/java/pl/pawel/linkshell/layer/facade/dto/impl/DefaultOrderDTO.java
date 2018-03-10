package pl.pawel.linkshell.layer.facade.dto.impl;

import java.util.Objects;
import pl.pawel.linkshell.layer.facade.dto.OrderDTO;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;

/**
 * Created on 12.08.2017.
 *
 */
public class DefaultOrderDTO implements OrderDTO {

  private Item item;
  private Price stockPrice;
  private int quantity;
  private Price totalPrice;
  private boolean specialOffer;

  @Override
  public Item getItem() {
    return this.item;
  }

  @Override
  public Price getStockPrice() {
    return this.stockPrice;
  }

  @Override
  public Price getTotalPrice() {
    return this.totalPrice;
  }

  @Override
  public void setTotalPrice(Price totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public int getQuantity() {
    return this.quantity;
  }

  @Override
  public void setItem(Item productName) {
    this.item = productName;
  }

  @Override
  public void setStockPrice(Price stockPrice) {
    this.stockPrice = stockPrice;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean isSpecialOffer() {
    return this.specialOffer;
  }

  @Override
  public void setSpecialOffer(boolean specialOffer) {
    this.specialOffer = specialOffer;
  }

  @Override
  public String toString() {
    return "DefaultOrderDTO{" +
        "item=" + item +
        ", stockPrice=" + stockPrice +
        ", quantity=" + quantity +
        ", totalPrice=" + totalPrice +
        ", specialOffer=" + specialOffer +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultOrderDTO orderDTO = (DefaultOrderDTO) o;
    return Objects.equals(item, orderDTO.item);
  }

  @Override
  public int hashCode() {
    int prime = 13;

    return prime + item.getId() + item.getName().hashCode();
  }
}
