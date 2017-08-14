package pl.koszela.jan.layer.service;

import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.service.dao.impl.DefaultCartDAO;
import pl.koszela.jan.layer.facade.dto.impl.DefaultOrderDTO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartService {

  DefaultCartDAO getCart();

  void addOrder(DefaultOrderDTO newOrderDTO);

  void removeOrder(DefaultOrderDTO orderDTO);

  Price getCartPrice();
}
