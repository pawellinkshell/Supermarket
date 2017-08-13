package pl.koszela.jan.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.Order;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.dto.PriceDTO;
import pl.koszela.jan.service.OrderService;
import pl.koszela.jan.service.PriceService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("orderService")
public class DefaultOrderService implements OrderService {

  private static List<Order> orders;

  @Autowired
  PriceService priceService;

  public DefaultOrderService() {
    this.orders = new ArrayList<>();
  }

  @Override
  public Order findOrderByName(String productName) {
    for (Iterator<Order> i = orders.iterator(); i.hasNext(); ) {
      Order currentOrder = i.next();
      if (isSameProduct(productName, currentOrder)) {
        return currentOrder;
      }
    }
    return null;
  }

  private boolean isSameProduct(String productName, Order currentOrder) {
    return productName.equals(currentOrder.getProduct());
  }

  @Override
  public boolean createOrder(Order order) {
    if (order.getQuantity() > 0) {
      order.setPrice(calculatePrice(order.getProduct(), order.getQuantity()));

      return this.orders.add(order);
    }

    return false;
  }

  private Price calculatePrice(Product product, int quantity) {
    Price price = null;

    if (product.isMultipricing()) {
      for (PriceDTO dto : priceService.getSpecialPrices()) {
        if (dto.getId() == product.getId()) {
          price = SpecialPrice.builder()
              .id(dto.getId())
              .amount(quantity)
              .price(dto.getPrice())
              .currency(dto.getCurrency())
              .build();
          break;
        }
      }
    } else {
      for (PriceDTO dto : priceService.getNormalPrices()) {
        if (dto.getId() == product.getId()) {
          price = NormalPrice.builder()
              .id(dto.getId())
              .price(dto.getPrice() * quantity)
              .currency(dto.getCurrency())
              .build();
          break;
        }
      }
    }
    return price;
  }


  @Override
  public void updateOrder(Order newOrder) {
    Order foundOrder = findOrderByName(newOrder.getProduct().getName());
    if (foundOrder != null) {
      if (newOrder.getQuantity() > 0) {
        orders.set(getIdFromOrders(foundOrder), newOrder);
      } else {
        orders.remove(getIdFromOrders(foundOrder));
      }
    }
  }

  private int getIdFromOrders(Order order) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).equals(order)) {
        return i;
      }
    }

    throw new IndexOutOfBoundsException("Method should be null-checked before in calls");
  }

  @Override
  public boolean removeOrder(Order order) {
    Order foundOrder = findOrderByName(order.getProduct().getName());
    if (foundOrder != null) {
      orders.remove(getIdFromOrders(foundOrder));

      return true;
    }
    return false;
  }

}
