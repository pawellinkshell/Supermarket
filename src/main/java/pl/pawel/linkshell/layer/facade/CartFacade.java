package pl.pawel.linkshell.layer.facade;


import pl.pawel.linkshell.layer.facade.dto.CartDTO;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartFacade {

  CartDTO getCart();

  boolean removeOrderFromCart(String product);

  boolean addOrderToCart(String product, String quantity);

  boolean updateOrderInCart(String product, String quantity);
}
