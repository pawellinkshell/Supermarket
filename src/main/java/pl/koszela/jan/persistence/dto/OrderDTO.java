package pl.koszela.jan.persistence.dto;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface OrderDTO {

  ProductDTO getProduct();

  PriceDTO getStockPrice();

  PriceDTO getTotalPrice();

  void setTotalPrice(PriceDTO totalPrice);

  int getQuantity();

  void setProduct(ProductDTO productName);

  void setStockPrice(PriceDTO stockPrice);

  void setQuantity(int quantity);

  boolean isSpecialOffer();

  void setSpecialOffer(boolean specialOffer);

}
