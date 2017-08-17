package pl.koszela.jan.layer.facade.mapper.impl;

import pl.koszela.jan.layer.facade.dto.CartDTO;
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.facade.dto.OrderDTO;
import pl.koszela.jan.layer.facade.dto.PriceDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;

/**
 * Created on 16.08.2017.
 *
 * @author Jan Koszela
 */
public class Maps<T> {

  public static <T> Mapper getMapper(T object) {
    if (((Class) object).getSimpleName().equals(ItemDTO.class.getSimpleName())) {
      return new ItemMapper();
    }

    if (((Class) object).getSimpleName().equals(PriceDTO.class.getSimpleName())) {
      return new StockPriceMapper();
    }

    if (((Class) object).getSimpleName().equals(OrderDTO.class.getSimpleName())) {
      return new OrderMapper();
    }

    if (((Class) object).getSimpleName().equals(CartDTO.class.getSimpleName())) {
      return new CartMapper();
    }

    return null;
  }

}

