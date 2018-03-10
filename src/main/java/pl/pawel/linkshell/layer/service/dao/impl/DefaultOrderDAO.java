package pl.pawel.linkshell.layer.service.dao.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.service.dao.OrderDAO;
import pl.pawel.linkshell.main.annotation.SessionScope;

/**
 * Created on 14.08.2017.
 *
 */
@Component("orderDAO")
@SessionScope
public class DefaultOrderDAO implements OrderDAO {

  private List<Order> orders;

  public DefaultOrderDAO() {
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
    return currentOrder.getItem().getName().equals(productName);
  }

  @Override
  public boolean addOrder(Order order) {
    return orders.add(order);
  }

  @Override
  public int findId(Order order) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).equals(order)) {
        return i;
      }
    }

    return -1;
  }

  @Override
  public boolean removeOrder(int id) {
    try {
      orders.remove(id);
      return true;
    } catch (RuntimeException exception) {
      return false;
    }
  }

  @Override
  public boolean updateOrder(int orderId, Order order) {
    try {
      orders.set(orderId, order);
      return true;
    } catch (RuntimeException exception) {
      return false;
    }
  }
}
