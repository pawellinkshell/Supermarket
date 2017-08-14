package pl.koszela.jan.layer.service;

import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.service.dao.CartDAO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  CartDAO getCart();

  void addToCart(Order order);

  void removeOrderFromCart(Order order);

  Price getPriceCart();
}
