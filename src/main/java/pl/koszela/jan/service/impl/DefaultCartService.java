package pl.koszela.jan.service.impl;

import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.service.CartService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static Set<Order> orders;

  @Autowired
  private ProductService productService;

  public DefaultCartService() {
    this.orders = new HashSet<>();
  }

  @Override
  public Set<Order> getOrders() {
    return this.orders;
  }

  @Override
  public void addOrderToCart(Order order) {
    orders.add(order);
  }

  @Override
  public void removeOrderFromCart(Order order) {
    orders.remove(order);
  }
}
