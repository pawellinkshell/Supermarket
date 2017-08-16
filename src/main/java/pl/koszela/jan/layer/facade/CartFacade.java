package pl.koszela.jan.layer.facade;

import pl.koszela.jan.layer.facade.dto.CartDTO;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartFacade {

  CartDTO getCart();

  boolean removeOrderFromCart(String product);

  boolean addOrderToCart(String product, String quantity);
}
