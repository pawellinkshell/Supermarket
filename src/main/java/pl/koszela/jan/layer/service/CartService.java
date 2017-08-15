package pl.koszela.jan.layer.service;

import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Cart;
import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  Cart getCart();

  void addToCart(Order order);

  void removeOrderFromCart(Order order);

  Price getPriceCart();
}
