package pl.koszela.jan.layer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.service.CartService;
import pl.koszela.jan.layer.service.dao.CartDAO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  @Autowired
  private CartDAO cartDAO;

  @Override
  public CartDAO getCart() {
    return this.cartDAO;
  }

  @Override
  public void addToCart(Order order) {
    cartDAO.add(order);
  }

  @Override
  public void removeOrderFromCart(Order order) {
    cartDAO.removeOrder(order);
  }

  @Override
  public Price getPriceCart() {
    return cartDAO.getPrice();
  }
}
