package pl.koszela.jan.layer.facade.dto.impl;

import java.util.List;
import pl.koszela.jan.layer.facade.dto.CartDTO;
import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 16.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultCartDTO implements CartDTO {

  private List<Order> orders;
  private String currency;

  @Override
  public List<Order> getOrders() {
    return orders;
  }

  @Override
  public void setOrders(List<Order> orders) {
    this.orders = orders;
  }

  @Override
  public String getCurrency() {
    return currency;
  }

  @Override
  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public double getPrice() {
    double price = 0.0d;

    for (Order order : orders) {
      price += order.getTotalPrice().getUnit();
    }

    return price;
  }

  @Override
  public String toString() {
    return "DefaultCartDTO{" +
        "orders=" + orders +
        ", currency='" + currency + '\'' +
        '}';
  }
}
