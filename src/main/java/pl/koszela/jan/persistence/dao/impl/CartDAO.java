package pl.koszela.jan.persistence.dao.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dto.impl.OrderDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class CartDAO {

  private Set<OrderDTO> orders;

  public CartDAO() {
    this.orders = new LinkedHashSet<>();
  }

  public Set<OrderDTO> getOrders() {
    return this.orders;
  }

  public void add(OrderDTO orderDTO) {
    if (orderDTO.getQuantity() > 0) {

      if (orders.contains(orderDTO)){
        removeOrder(orderDTO);
      }
      orders.add(orderDTO);

    } else {
      if (orders.contains(orderDTO)) {
        removeOrder(orderDTO);
      }
    }
  }

  private void removeOrder(OrderDTO orderDTO) {
    for (Iterator<OrderDTO> i = this.orders.iterator(); i.hasNext(); ) {
      if (i.next().getProduct() == orderDTO.getProduct()) {
        i.remove();
        break;
      }
    }
  }

  public void remove(OrderDTO orderDTO) {
    orders.remove(orderDTO);
  }

  public Price getPrice() {
//    Price totalPrice = new NormalPrice();
//    for (OrderDTO order : orders) {
//      totalPrice.setUnit(totalPrice.getUnit() + order.getTotalPrice().getUnit());
//    }
//    return totalPrice;
    return null;
  }

  @Override
  public String toString() {
    return "CartDAO{" +
        "orders=" + orders +
        '}';
  }
}
