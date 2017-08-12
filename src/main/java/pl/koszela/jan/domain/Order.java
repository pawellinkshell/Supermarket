package pl.koszela.jan.domain;

import java.util.Objects;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class Order {

  private String productName;
  private int quantity;

  public Order(String productName, int quantity) {
    this.productName = productName;
    this.quantity = quantity;
  }


  public String getProductName() {
    return this.productName;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setProductName(String productName) {
    this.productName = productName;
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
    return Objects.equals(productName, order.productName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productName, quantity);
  }
}
