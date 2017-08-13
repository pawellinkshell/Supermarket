package pl.koszela.jan.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductMapper;
import pl.koszela.jan.service.CartService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static List<Order> orders;

  @Autowired
  private ProductService productService;

  public DefaultCartService() {
    this.orders = new ArrayList<>();
  }

  @Override
  public List<Order> getOrders() {
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
