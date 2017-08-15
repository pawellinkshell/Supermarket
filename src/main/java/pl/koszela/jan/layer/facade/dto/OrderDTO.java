package pl.koszela.jan.layer.facade.dto;

import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
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
