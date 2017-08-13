package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  List<Order> getOrders();

  void addOrderToCart(Order newOrder);

  void removeOrderFromCart(Order order);
}
