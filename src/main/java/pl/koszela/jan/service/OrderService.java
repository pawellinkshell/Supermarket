package pl.koszela.jan.service;

import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.domain.impl.Product;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  Order findOrderByName(String productName);

  boolean createOrder(Order order);

  void updateOrder(Order order);

  boolean removeOrder(Order removedOrder);

}
