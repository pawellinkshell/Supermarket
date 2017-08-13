package pl.koszela.jan.domain.impl;

import java.util.HashSet;
import java.util.Set;
import pl.koszela.jan.domain.Price;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class Cart {

  private Set<Order> orders;

  public Cart() {
    this.orders = new HashSet<>();
  }

  public Set<Order> getOrders() {
    return this.orders;
  }
  public void add(Order order) {
    orders.add(order);
  }

  public void remove(Order order) {
    orders.remove(order);
  }

  public Price getPrice() {
    Price totalPrice = new NormalPrice();
    for (Order order : orders) {
      totalPrice.setUnit(totalPrice.getUnit() + order.getTotalPrice().getUnit());
    }
    return totalPrice;
  }

  @Override
  public String toString() {
    return "Cart{" +
        "orders=" + orders +
        '}';
  }
}
