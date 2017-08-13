package pl.koszela.jan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Order;
import pl.koszela.jan.service.OrderService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("orderService")
public class DefaultOrderService implements OrderService {

  private static List<Order> orders;

  public DefaultOrderService() {
    this.orders = new ArrayList<>();
  }

  @Override
  public Order findOrderByName(String productName) {
    for (Iterator<Order> i = orders.iterator(); i.hasNext(); ) {
      Order currentOrder = i.next();
      if (isSameProduct(productName, currentOrder)) {
        return currentOrder;
      }
    }
    return null;
  }

  private boolean isSameProduct(String productName, Order currentOrder) {
    return productName.equals(currentOrder.getProductName());
  }

  @Override
  public boolean createOrder(Order order) {
    return this.orders.add(order);
  }

  @Override
  public void updateOrder(Order newOrder) {
    Order foundOrder = findOrderByName(newOrder.getProductName());
    if (foundOrder != null) {
      orders.set(getIdFromOrders(foundOrder), newOrder);
    }

  }

  private int getIdFromOrders(Order order) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).equals(order)) {
        return i;
      }
    }

    throw new IndexOutOfBoundsException("Method should be null-checked before in calls");
  }

  @Override
  public boolean removeOrder(Order order) {
    Order foundOrder = findOrderByName(order.getProductName());
    if (foundOrder != null) {
      orders.remove(getIdFromOrders(foundOrder));

      return true;
    }
    return false;
  }
}
