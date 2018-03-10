package pl.pawel.linkshell.layer.service;

import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;
import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 */
public interface CartService {

  Cart getCart();

  boolean addToCart(Order order);

  boolean removeOrderFromCart(Order order);

  Price getPriceCart();

  boolean updateOrderInCart(Order order);
}
