package pl.pawel.linkshell.layer.service;

import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 12.08.2017.
 *
 */
public interface OrderService {

  Order getOrderByName(String productName);

  boolean updateOrder(String product, int quantity);

  boolean removeOrder(Order removedOrder);

  boolean createOrder(String product, int quantity);
}
