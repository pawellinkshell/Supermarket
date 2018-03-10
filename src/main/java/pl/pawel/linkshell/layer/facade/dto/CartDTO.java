package pl.pawel.linkshell.layer.facade.dto;

import java.util.List;
import pl.pawel.linkshell.layer.model.domain.impl.Order;

/**
 * Created on 16.08.2017.
 *
 */
public interface CartDTO {

  List<Order> getOrders();

  void setOrders(List<Order> orders);

  String getCurrency();

  void setCurrency(String currency);

  double getPrice();

}
