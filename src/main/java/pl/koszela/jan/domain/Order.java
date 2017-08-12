package pl.koszela.jan.domain;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class Order {

  private String productName;
  private String quantity;

  @java.beans.ConstructorProperties({"productName", "quantity"})
  Order(String productName, String quantity) {
    this.productName = productName;
    this.quantity = quantity;
  }

  public static OrderBuilder builder() {
    return new OrderBuilder();
  }

  public String getProductName() {
    return this.productName;
  }

  public String getQuantity() {
    return this.quantity;
  }

  public void setProductName(String productName) {
    this.productName = productName;
  }

  public void setQuantity(String quantity) {
    this.quantity = quantity;
  }

  public static class OrderBuilder {

    private String productName;
    private String quantity;

    OrderBuilder() {
    }

    public Order.OrderBuilder productName(String productName) {
      this.productName = productName;
      return this;
    }

    public Order.OrderBuilder quantity(String quantity) {
      this.quantity = quantity;
      return this;
    }

    public Order build() {
      return new Order(productName, quantity);
    }

    public String toString() {
      return "pl.koszela.jan.domain.Order.OrderBuilder(productName=" + this.productName
          + ", quantity=" + this.quantity + ")";
    }
  }
}
