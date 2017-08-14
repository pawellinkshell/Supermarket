package pl.koszela.jan.layer.service;

import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  Order getOrderByName(String productName);

  boolean createOrder(Order orderDTO);

  boolean updateOrder(Order orderDTO);

  boolean removeOrder(Order removedOrderDTO);

}
