package pl.koszela.jan.layer.facade.impl;

import org.springframework.beans.factory.annotation.Autowired;
import pl.koszela.jan.layer.facade.CartFacade;
import pl.koszela.jan.layer.facade.dto.CartDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;
import pl.koszela.jan.layer.facade.mapper.impl.Maps;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.service.CartService;
import pl.koszela.jan.layer.service.OrderService;
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

  @Autowired
  private OrderService orderService;

  @Override
  public CartDTO getCart() {

    if ((cart == null) ||
        (cart.hashCode() != cartService.getCart().hashCode())) {

      Mapper cartMapper = Maps.getMapper(CartDTO.class);
      cart = (CartDTO) cartMapper.map(cartService.getCart());
    }

    return cart;
  }

  @Override
  public boolean removeOrderFromCart(String product) {
    Order foundOrder = orderService.getOrderByName(product);
    return cartService.removeOrderFromCart(foundOrder);
  }

  @Override
  public boolean addOrderToCart(String product, String quantity) {

    Order foundOrder = orderService.getOrderByName(product);
    Order newOrder = null;

    if (isOrderFound(foundOrder)) {
      newOrder = orderService.createOrder(product, Integer.parseInt(quantity));
    } else {
      if (isNewQuantityDifferent(quantity, foundOrder)) {
        orderService.updateOrder(product, Integer.parseInt(quantity));
      } else {
        newOrder = foundOrder;
      }
    }

    return cartService.addToCart(newOrder);
  }

  private boolean isNewQuantityDifferent(String quantity, Order foundOrder) {
    return foundOrder.getQuantity() != Integer.parseInt(quantity);
  }

  private boolean isOrderFound(Order foundOrder) {
    return foundOrder == null;
  }
}
