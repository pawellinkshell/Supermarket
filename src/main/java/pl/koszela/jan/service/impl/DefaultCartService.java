package pl.koszela.jan.service.impl;

import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Cart;
import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.service.CartService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static Cart cart;

  public DefaultCartService() {
    this.cart = new Cart();
  }

  @Override
  public Cart getCart() {
    return this.cart;
  }

  @Override
  public void addOrder(Order order) {
    cart.add(order);
  }

  @Override
  public void removeOrder(Order order) {
    cart.remove(order);
  }

  @Override
  public Price getCartPrice() {
    return cart.getPrice();
  }
}
