package pl.pawel.linkshell.layer.facade.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import pl.pawel.linkshell.layer.facade.dto.CartDTO;
import pl.pawel.linkshell.layer.facade.dto.impl.DefaultCartDTO;
import pl.pawel.linkshell.layer.facade.mapper.Mapper;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;

/**
 * Created on 16.08.2017.
 *
 */
public class CartMapper implements Mapper<Cart, CartDTO> {

  @Override
  public CartDTO map(Cart from) {
    CartDTO dto = new DefaultCartDTO();
    dto.setOrders(from.getOrders());
    dto.setCurrency(from.getCurrency());

    return dto;
  }

  @Override
  public List<CartDTO> map(List<Cart> carts) {
    List<CartDTO> dtos = new ArrayList<>();

    for (Cart cart : carts) {
      dtos.add(map(cart));
    }

    return dtos;
  }
}
