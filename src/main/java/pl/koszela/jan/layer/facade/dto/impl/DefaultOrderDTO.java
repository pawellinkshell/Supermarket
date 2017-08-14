package pl.koszela.jan.layer.facade.dto.impl;

import java.util.Objects;
import pl.koszela.jan.layer.facade.dto.OrderDTO;
import pl.koszela.jan.layer.facade.dto.PriceDTO;
import pl.koszela.jan.layer.facade.dto.ProductDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultOrderDTO implements OrderDTO {

  private ProductDTO product;
  private PriceDTO stockPrice;
  private int quantity;
  private PriceDTO totalPrice;
  private boolean specialOffer;


  public DefaultOrderDTO(ProductDTO product, int quantity) {
    this.product = product;
    this.quantity = quantity;
    this.stockPrice = null;
    this.totalPrice = null;
    this.specialOffer = false;
  }

  @Override
  public ProductDTO getProduct() {
    return this.product;
  }

  @Override
  public PriceDTO getStockPrice() {
    return this.stockPrice;
  }

  @Override
  public PriceDTO getTotalPrice() {
    return this.totalPrice;
  }

  @Override
  public void setTotalPrice(PriceDTO totalPrice) {
    this.totalPrice = totalPrice;
  }

  @Override
  public int getQuantity() {
    return this.quantity;
  }

  @Override
  public void setProduct(ProductDTO productName) {
    this.product = productName;
  }

  @Override
  public void setStockPrice(PriceDTO stockPrice) {
    this.stockPrice = stockPrice;
  }

  @Override
  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }

  @Override
  public boolean isSpecialOffer() {
    return this.specialOffer;
  }

  @Override
  public void setSpecialOffer(boolean specialOffer) {
    this.specialOffer = specialOffer;
  }

  @Override
  public String toString() {
    return "DefaultOrderDTO{" +
        "product=" + product +
        ", stockPrice=" + stockPrice +
        ", quantity=" + quantity +
        ", totalPrice=" + totalPrice +
        ", specialOffer=" + specialOffer +
        '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    DefaultOrderDTO orderDTO = (DefaultOrderDTO) o;
    return Objects.equals(product, orderDTO.product);
  }

  @Override
  public int hashCode() {
    int prime = 13;

    int result = prime + product.getId() + product.getItem().hashCode();
    return result;
  }
}
