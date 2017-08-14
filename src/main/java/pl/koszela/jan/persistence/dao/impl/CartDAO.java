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

  private Set<OrderDTO> orderDTOS;

  public CartDAO() {
    this.orderDTOS = new LinkedHashSet<>();
  }

  public Set<OrderDTO> getOrderDTOS() {
    return this.orderDTOS;
  }

  public void add(OrderDTO orderDTO) {
    if (orderDTO.getQuantity() > 0) {

      if (orderDTOS.contains(orderDTO)){
        removeOrder(orderDTO);
      }
      orderDTOS.add(orderDTO);

    } else {
      if (orderDTOS.contains(orderDTO)) {
        removeOrder(orderDTO);
      }
    }
  }

  private void removeOrder(OrderDTO orderDTO) {
    for (Iterator<OrderDTO> i = this.orderDTOS.iterator(); i.hasNext(); ) {
      if (i.next().getProduct() == orderDTO.getProduct()) {
        i.remove();
        break;
      }
    }
  }

  public void remove(OrderDTO orderDTO) {
    orderDTOS.remove(orderDTO);
  }

  public Price getPrice() {
//    Price totalPrice = new NormalPrice();
//    for (OrderDTO order : orderDTOS) {
//      totalPrice.setUnit(totalPrice.getUnit() + order.getTotalPrice().getUnit());
//    }
//    return totalPrice;
    return null;
  }

  @Override
  public String toString() {
    return "CartDAO{" +
        "orderDTOS=" + orderDTOS +
        '}';
  }
}
