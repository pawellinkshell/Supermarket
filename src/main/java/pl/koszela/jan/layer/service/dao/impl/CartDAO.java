package pl.koszela.jan.layer.service.dao.impl;

import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.facade.dto.impl.DefaultOrderDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class CartDAO {

  private Set<DefaultOrderDTO> orders;

  public CartDAO() {
    this.orders = new LinkedHashSet<>();
  }

  public Set<DefaultOrderDTO> getOrders() {
    return this.orders;
  }

  public void add(DefaultOrderDTO orderDTO) {
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

  private void removeOrder(DefaultOrderDTO orderDTO) {
    for (Iterator<DefaultOrderDTO> i = this.orders.iterator(); i.hasNext(); ) {
      if (i.next().getProduct() == orderDTO.getProduct()) {
        i.remove();
        break;
      }
    }
  }

  public void remove(DefaultOrderDTO orderDTO) {
    orders.remove(orderDTO);
  }

  public Price getPrice() {
//    Price totalPrice = new StockPrice();
//    for (DefaultOrderDTO order : orders) {
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
