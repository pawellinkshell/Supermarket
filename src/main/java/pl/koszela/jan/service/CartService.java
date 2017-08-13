package pl.koszela.jan.service;

import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Cart;
import pl.koszela.jan.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  Cart getCart();

  void addOrder(Order newOrder);

  void removeOrder(Order order);

  Price getCartPrice();
}
