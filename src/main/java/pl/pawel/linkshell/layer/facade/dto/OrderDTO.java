package pl.pawel.linkshell.layer.facade.dto;

import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;

/**
 * Created on 14.08.2017.
 *
 */
public interface OrderDTO {

  Item getItem();

  Price getStockPrice();

  Price getTotalPrice();

  void setTotalPrice(Price totalPrice);

  int getQuantity();

  void setItem(Item productName);

  void setStockPrice(Price stockPrice);

  void setQuantity(int quantity);

  boolean isSpecialOffer();

  void setSpecialOffer(boolean specialOffer);

}
