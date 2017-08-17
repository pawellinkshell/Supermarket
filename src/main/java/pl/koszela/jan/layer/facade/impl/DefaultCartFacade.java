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
import pl.koszela.jan.main.annotation.SessionScope;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
@Facade("cartFacade")
@SessionScope
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
    orderService.removeOrder(foundOrder);
    return cartService.removeOrderFromCart(foundOrder);
  }

  @Override
  public boolean addOrderToCart(String product, String quantity) {

    Order foundOrder = orderService.getOrderByName(product);

    if (foundOrder == null) {
      orderService.createOrder(product, Integer.valueOf(quantity));
      foundOrder = orderService.getOrderByName(product);

      return (foundOrder != null) ? cartService.addToCart(foundOrder) : false;
    } else {
      return false;
    }
  }

  @Override
  public boolean updateOrderInCart(String product, String quantity) {
    Order foundOrder = orderService.getOrderByName(product);

    if (foundOrder != null) {
      if (isValidQuantity(Integer.parseInt(quantity), foundOrder)) {
        orderService.updateOrder(product, Integer.parseInt(quantity));
        foundOrder = orderService.getOrderByName(product);
      } else {
        return false;
      }
    }

    return (foundOrder != null) ? cartService.updateOrderInCart(foundOrder) : false;
  }

  private boolean isValidQuantity(int quantity, Order foundOrder) {
    if (quantity == foundOrder.getQuantity()) {
      return false;
    } else if (quantity > 0) {
      return foundOrder.getQuantity() != quantity;
    } else {
      return false;
    }
  }
}
