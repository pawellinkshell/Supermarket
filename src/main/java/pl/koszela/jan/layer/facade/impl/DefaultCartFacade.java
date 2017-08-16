package pl.koszela.jan.layer.facade.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import pl.koszela.jan.layer.facade.CartFacade;
import pl.koszela.jan.layer.facade.dto.CartDTO;
import pl.koszela.jan.layer.facade.dto.OrderDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;
import pl.koszela.jan.layer.facade.mapper.impl.Maps;
import pl.koszela.jan.layer.service.CartService;
import pl.koszela.jan.main.annotation.Facade;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
@Facade("cartFacade")
public class DefaultCartFacade implements CartFacade {

  private CartDTO cart;

  @Autowired
  private CartService cartService;

  @Override
  public List<OrderDTO> getOrdersFromCart() {
    return null;
  }

  @Override
  public CartDTO getCart() {

    if ((cart == null) ||
        (cart.hashCode() != cartService.getCart().hashCode())) {

      Mapper cartMapper = Maps.getMapper(CartDTO.class);
      cart = (CartDTO) cartMapper.map(cartService.getCart());
    }

    return cart;
  }
}
