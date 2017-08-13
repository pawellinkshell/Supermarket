package pl.koszela.jan.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductMapper;
import pl.koszela.jan.service.CartService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("cartService")
public class DefaultCartService implements CartService {

  private static Map<Order, Price> orders;

  @Autowired
  private ProductService productService;

  public DefaultCartService() {
    this.orders = new HashMap<>();
  }

  @Override
  public Map<Order, Price> getOrders() {
    return this.orders;
  }

  @Override
  public void addOrderToCart(Order order) {
    Price price = getPrice(order);
    ProductDTO productDTO = getProductDetails(order);

    order.setProduct(fillByProductDetails(productDTO));
    orders.put(order, price);
  }

  private Price getPrice(Order order) {
    Price price;
    if (isSpecialPrice(order)) {
      price = SpecialPrice.builder()
          .id(order.getProduct().getId())
          .amount(order.getQuantity())
          .currency(order.getProduct().getCurrency())
          .price(order.getProduct().getUnitPrice())
          .build();
    }

    return null;
  }

  private boolean isSpecialPrice(Order order) {
    return order.getProduct().isMultipricing();
  }

  private Product fillByProductDetails(ProductDTO productDTO) {

    return DefaultProductMapper.map(productDTO);
  }

  private ProductDTO getProductDetails(Order newOrder) {
    ProductDTO productDTO;
    for (Iterator<ProductDTO> i =  productService.getProducts().iterator(); i.hasNext(); ) {
      productDTO = i.next();
      if (productDTO.getItem().equals(newOrder.getProduct().getItem())) {
        return productDTO;
      }
    }

    return null;

  }

  @Override
  public void removeOrderFromCart(Order order) {
    orders.remove(order);
  }
}
