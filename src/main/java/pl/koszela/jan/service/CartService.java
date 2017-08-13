package pl.koszela.jan.service;

import java.util.Set;
import pl.koszela.jan.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  Set<Order> getOrders();

  void addOrderToCart(Order newOrder);

  void removeOrderFromCart(Order order);
}
