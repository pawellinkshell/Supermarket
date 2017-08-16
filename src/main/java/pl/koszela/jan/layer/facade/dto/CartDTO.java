package pl.koszela.jan.layer.facade.dto;

import java.util.List;
import pl.koszela.jan.layer.model.domain.impl.Order;

/**
 * Created on 16.08.2017.
 *
 * @author Jan Koszela
 */
public interface CartDTO {

  List<Order> getOrders();

  void setOrders(List<Order> orders);

  String getCurrency();

  void setCurrency(String currency);

  double getPrice();

}
