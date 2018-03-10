package pl.pawel.linkshell.layer.facade.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import pl.pawel.linkshell.layer.facade.dto.OrderDTO;
import pl.pawel.linkshell.layer.facade.dto.impl.DefaultOrderDTO;
import pl.pawel.linkshell.layer.facade.mapper.Mapper;
import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 15.08.2017.
 *
 */
public class OrderMapper implements Mapper<Order, OrderDTO> {

  @Override
  public OrderDTO map(Order from) {
    OrderDTO dto = new DefaultOrderDTO();
    dto.setItem(from.getItem());
    dto.setQuantity(from.getQuantity());
    dto.setSpecialOffer(from.isSpecialOffer());
    dto.setStockPrice(from.getStockPrice());
    dto.setTotalPrice(from.getTotalPrice());

    return dto;
  }

  @Override
  public List<OrderDTO> map(List<Order> orders) {
    List<OrderDTO> dtos = new ArrayList<>();

    for (Order order : orders) {
      dtos.add(map(order));
    }

    return dtos;
  }
}
