package pl.koszela.jan.service.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Order;
import pl.koszela.jan.service.CartService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static List<Order> orders;
  
  @Override
  public boolean findProduct(String product) {
    for(Iterator<Order> i = orders.iterator(); i.hasNext();) {
      Order order = i.next();
      if (isSameProduct(product, order)) {
        return true;
      }
    }
    return false;
  }

  private boolean isSameProduct(String product, Order order) {
    return order.getProductName().equals(product);
  }
}
