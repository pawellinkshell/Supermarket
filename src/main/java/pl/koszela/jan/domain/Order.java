package pl.koszela.jan.domain;

import java.util.Objects;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class Order {

  private Product product;
  private int quantity;

  public Order(String productName, int quantity) {
    this.product = Product.builder()
        .item(productName)
        .build();
    this.quantity = quantity;
  }


  public Product getProduct() {
    return this.product;
  }

  public int getQuantity() {
    return this.quantity;
  }

  public void setProduct(Product productName) {
    this.product = productName;
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
