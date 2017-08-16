package pl.koszela.jan.layer.facade;

import java.util.List;
import pl.koszela.jan.layer.facade.dto.CartDTO;
import pl.koszela.jan.layer.facade.dto.OrderDTO;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartFacade {

  List<OrderDTO> getOrdersFromCart();

  CartDTO getCart();

}
