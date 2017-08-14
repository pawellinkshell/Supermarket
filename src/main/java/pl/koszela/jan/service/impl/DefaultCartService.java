package pl.koszela.jan.service.impl;

import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dao.impl.CartDAO;
import pl.koszela.jan.persistence.dto.impl.DefaultOrderDTO;
import pl.koszela.jan.service.CartService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static CartDAO cart;

  public DefaultCartService() {
    this.cart = new CartDAO();
  }

  @Override
  public CartDAO getCart() {
    return this.cart;
  }

  @Override
  public void addOrder(DefaultOrderDTO orderDTO) {
    cart.add(orderDTO);
  }

  @Override
  public void removeOrder(DefaultOrderDTO orderDTO) {
    cart.remove(orderDTO);
  }

  @Override
  public Price getCartPrice() {
    return cart.getPrice();
  }
}
