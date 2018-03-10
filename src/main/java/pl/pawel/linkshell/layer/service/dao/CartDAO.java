package pl.pawel.linkshell.layer.service.dao;

import java.util.List;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;
import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 14.08.2017.
 *
 */
public interface CartDAO {

  List<Order> getOrdersFromCart();

  boolean add(Order order);

  boolean removeOrder(Order order);

  Price getPrice();

  Cart getCart();

  boolean update(Order order);
}
