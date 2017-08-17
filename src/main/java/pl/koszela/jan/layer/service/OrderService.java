package pl.koszela.jan.layer.service;

import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  Order getOrderByName(String productName);

  boolean updateOrder(String product, int quantity);

  boolean removeOrder(Order removedOrder);

  boolean createOrder(String product, int quantity);
}
