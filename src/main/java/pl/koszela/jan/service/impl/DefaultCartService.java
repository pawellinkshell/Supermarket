package pl.koszela.jan.service.impl;

import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dao.impl.CartDAO;
import pl.koszela.jan.persistence.dto.impl.OrderDTO;
import pl.koszela.jan.service.CartService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static CartDAO cartDAO;

  public DefaultCartService() {
    this.cartDAO = new CartDAO();
  }

  @Override
  public CartDAO getCart() {
    return this.cartDAO;
  }

  @Override
  public void addOrder(OrderDTO orderDTO) {
    cartDAO.add(orderDTO);
  }

  @Override
  public void removeOrder(OrderDTO orderDTO) {
    cartDAO.remove(orderDTO);
  }

  @Override
  public Price getCartPrice() {
    return cartDAO.getPrice();
  }
}
