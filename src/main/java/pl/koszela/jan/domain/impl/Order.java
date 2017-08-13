package pl.koszela.jan.domain.impl;

import java.util.Objects;
import org.springframework.beans.factory.annotation.Autowired;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dto.PriceDTO;
import pl.koszela.jan.service.PriceService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class Order {

  private Product product;
  private Price price;
  private int quantity;


  public Order(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
    this.price = null;
  }

  public Product getProduct() {
    return this.product;
  }

  public Price getPrice() {
    return price;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setProduct(Product productName) {
    this.product = productName;
  }

  public void setPrice(Price price) {
    this.price = price;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    Order order = (Order) o;
    return Objects.equals(product, order.product);
  }

  @Override
  public int hashCode() {
    return Objects.hash(product, quantity);
  }

  @Override
  public String toString() {
    return "Order{" +
        "productName='" + product + '\'' +
        ", quantity=" + quantity +
        '}';
  }
}
