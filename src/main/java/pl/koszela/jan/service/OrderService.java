package pl.koszela.jan.service;

import pl.koszela.jan.domain.Order;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  Order findOrderByName(String productName);

  void createOrder(Order order);

  void updateOrder(Order order);
}
