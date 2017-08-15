package pl.koszela.jan.layer.service.dao;

import java.util.List;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Cart;
import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartDAO {

  List<Order> getOrdersFromCart();

  boolean add(Order order);

  boolean removeOrder(Order order);

  Price getPrice();

  Cart getCart();
}
