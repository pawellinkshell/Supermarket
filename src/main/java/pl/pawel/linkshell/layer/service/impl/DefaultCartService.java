package pl.pawel.linkshell.layer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.service.CartService;
import pl.pawel.linkshell.layer.service.dao.CartDAO;
import pl.pawel.linkshell.main.annotation.SessionScope;

/**
 * Created on 13.08.2017.
 *
 */
@Service("cartService")
@SessionScope
public class DefaultCartService implements CartService {

  @Autowired
  private CartDAO cartDAO;

  @Override
  public Cart getCart() {
    return this.cartDAO.getCart();
  }

  @Override
  public boolean addToCart(Order order) {
    return cartDAO.add(order);
  }

  @Override
  public boolean removeOrderFromCart(Order order) {
    if (order == null) {
      return false;
    }
    return cartDAO.removeOrder(order);
  }

  @Override
  public Price getPriceCart() {
    return cartDAO.getPrice();
  }

  @Override
  public boolean updateOrderInCart(Order order) {
    return cartDAO.update(order);
  }


}
