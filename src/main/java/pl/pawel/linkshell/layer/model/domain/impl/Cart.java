package pl.pawel.linkshell.layer.model.domain.impl;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.List;

/**
 * Created on 15.08.2017.
 *
 */
public class Cart {

  @SerializedName("orders")
  private List<Order> orders;
  @SerializedName("currency")
  private String currency;

  public Cart() {
    this.orders = new ArrayList<>();
  }

  public List<Order> getOrders() {
    return orders;
  }

  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  public boolean addOrder(Order order) {
    return orders.add(order);
  }

  public double getPrice() {
    double price = 0.0d;

    for (Order order : orders) {
      price += order.getTotalPrice().getUnit();
    }

    return price;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public String getCurrency() {
    return this.currency;
  }

  @Override
  public String toString() {
    return "Cart{" +
        "orders=" + orders +
        ", currency='" + currency + '\'' +
        '}';
  }

  public boolean updateOrder(Order order) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).getItem().getId() == order.getItem().getId()) {
        try {
          orders.set(i, order);
          return true;
        } catch (RuntimeException exception) {
          return false;
        }
      }
    }

    return false;
  }
}
