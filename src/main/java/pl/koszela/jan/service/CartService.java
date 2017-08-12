package pl.koszela.jan.service;

import pl.koszela.jan.domain.Order;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  Order findOrderByName(String productName);
}
