package pl.koszela.jan.service;

import pl.koszela.jan.persistence.dto.impl.DefaultOrderDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderService {

  DefaultOrderDTO findOrderByName(String productName);

  boolean createOrder(DefaultOrderDTO orderDTO);

  void updateOrder(DefaultOrderDTO orderDTO);

  boolean removeOrder(DefaultOrderDTO removedOrderDTO);

}
