package pl.pawel.linkshell.layer.service.dao;

import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 14.08.2017.
 *
 */
public interface OrderDAO {

  Order findOrderByName(String productName);

  boolean addOrder(Order order);

  int findId(Order order);

  boolean removeOrder(int id);

  boolean updateOrder(int orderId, Order order);
}
