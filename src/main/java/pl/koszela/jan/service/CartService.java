package pl.koszela.jan.service;

import java.util.Map;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  Map<Order, Price> getOrders();

  void addOrderToCart(Order newOrder);

  void removeOrderFromCart(Order order);
}
