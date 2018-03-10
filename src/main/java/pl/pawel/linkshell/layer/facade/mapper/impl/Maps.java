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
    if (object == ItemDTO.class) {
      return new ItemMapper();
    }

    if (object == PriceDTO.class) {
      return new StockPriceMapper();
    }

    if (object == OrderDTO.class) {
      return new OrderMapper();
    }

    if (object == CartDTO.class) {
      return new CartMapper();
    }

    return null;
  }

}

