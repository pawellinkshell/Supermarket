package pl.koszela.jan.domain.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
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
    this.orders = new LinkedHashSet<>();
  }

  public Set<Order> getOrders() {
    return this.orders;
  }

  public void add(Order order) {
    if (order.getQuantity() > 0) {

      if (orders.contains(order)){
        removeOrder(order);
      }
      orders.add(order);

    } else {
      if (orders.contains(order)) {
        removeOrder(order);
      }
    }
  }

  private void removeOrder(Order order) {
    for (Iterator<Order> i = this.orders.iterator(); i.hasNext(); ) {
      if (i.next().getProduct() == order.getProduct()) {
        i.remove();
        break;
      }
    }
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
