package pl.pawel.linkshell.layer.facade.mapper.impl;

import pl.pawel.linkshell.layer.facade.dto.CartDTO;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;
import pl.pawel.linkshell.layer.facade.dto.OrderDTO;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;
import pl.pawel.linkshell.layer.facade.mapper.Mapper;

/**
 * Created on 16.08.2017.
 *
 */
public class Maps {

  private Maps() {
    throw new IllegalStateException("Utility class");
  }

  public static <T> Mapper getMapper(T object) {
    if (object.getClass().isAssignableFrom(ItemDTO.class)) {
      return new ItemMapper();
    }

    if (object.getClass().isAssignableFrom(PriceDTO.class)) {
      return new StockPriceMapper();
    }

    if (object.getClass().isAssignableFrom(OrderDTO.class)) {
      return new OrderMapper();
    }

    if (object.getClass().isAssignableFrom(CartDTO.class)) {
      return new CartMapper();
    }

    return null;
  }

}

