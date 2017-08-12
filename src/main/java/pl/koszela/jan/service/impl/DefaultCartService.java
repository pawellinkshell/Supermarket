package pl.koszela.jan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Order;
import pl.koszela.jan.domain.Product;
import pl.koszela.jan.service.CartService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static List<Order> orders;

  public DefaultCartService() {
    orders = new ArrayList<>();
  }

  @Override
  public Order findOrderByName(String productName) {
    for(Iterator<Order> i = orders.iterator(); i.hasNext();) {
      Order currentOrder = i.next();
      if (isSameProduct(productName, currentOrder)) {
        return currentOrder;
      }
    }
    return null;
  }

  private boolean isSameProduct(String productName, Order currentOrder) {
    return productName.equals(currentOrder.getProductName());
  }


}
