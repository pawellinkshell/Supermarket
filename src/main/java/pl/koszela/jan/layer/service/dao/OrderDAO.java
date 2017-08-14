package pl.koszela.jan.layer.service.dao;

import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderDAO {

  Order findOrderByName(String productName);

  boolean addOrder(Order order);

  int findId(Order order);

  boolean removeOrder(int id);

  boolean updateOrder(int orderId, Order order);
}
