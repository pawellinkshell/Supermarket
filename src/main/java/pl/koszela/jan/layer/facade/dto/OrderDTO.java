package pl.koszela.jan.layer.facade.dto;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderDTO {

  ItemDTO getItem();

  PriceDTO getStockPrice();

  PriceDTO getTotalPrice();

  void setTotalPrice(PriceDTO totalPrice);

  int getQuantity();

  void setItem(ItemDTO productName);

  void setStockPrice(PriceDTO stockPrice);

  void setQuantity(int quantity);

  boolean isSpecialOffer();

  void setSpecialOffer(boolean specialOffer);

}
