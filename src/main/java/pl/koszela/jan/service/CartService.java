package pl.koszela.jan.service;

import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dto.impl.DefaultOrderDTO;
import pl.koszela.jan.persistence.dao.impl.CartDAO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  CartDAO getCart();

  void addOrder(DefaultOrderDTO newOrderDTO);

  void removeOrder(DefaultOrderDTO orderDTO);

  Price getCartPrice();
}
