package pl.koszela.jan.service;

import pl.koszela.jan.persistence.dto.impl.OrderDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  OrderDTO findOrderByName(String productName);

  boolean createOrder(OrderDTO orderDTO);

  void updateOrder(OrderDTO orderDTO);

  boolean removeOrder(OrderDTO removedOrderDTO);

}
