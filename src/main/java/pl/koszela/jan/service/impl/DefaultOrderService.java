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
import pl.koszela.jan.persistence.dto.impl.SpecialPriceDTO;
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
    return productName.equals(currentOrder.getProduct().getName());
  }

  @Override
  public boolean createOrder(Order order) {
    if (order.getQuantity() > 0) {
      order.setStockPrice(getStockPrice(order.getProduct()));

      Price totalPrice = calculateTotalPrice(order.getProduct(), order.getQuantity());
      order.setTotalPrice(totalPrice);

      if (totalPrice instanceof SpecialPrice) {
        order.setSpecialOffer(true);
      }

      return this.orders.add(order);

    } else {

      int idFromOrders = getIdFromOrders(order);
      if (idFromOrders > Integer.MIN_VALUE) {
        orders.remove(idFromOrders);
      }
    }

    return false;
  }

  private Price calculateTotalPrice(Product product, int quantity) {
    Price price = getSpecialPrice(product, quantity);

    if (price == null) {
      price = getStockPrice(product);
      price.setUnit(price.getUnit() * quantity);
    }

    return price;
  }

  private Price getSpecialPrice(Product product, int quantity) {
    Price price = null;

    for (SpecialPriceDTO dto : priceService.getSpecialPrices()) {
      if (dto.getId() == product.getId() &&
          dto.getAmount() == quantity) {
        price = SpecialPrice.builder()
            .id(dto.getId())
            .amount(dto.getAmount())
            .price(dto.getPrice())
            .currency(dto.getCurrency())
            .build();
        break;
      }
    }
    return price;
  }

  private Price getStockPrice(Product product) {
    Price price = null;

    for (PriceDTO dto : priceService.getNormalPrices()) {
      if (dto.getId() == product.getId()) {
        price = NormalPrice.builder()
            .id(dto.getId())
            .price(dto.getPrice())
            .currency(dto.getCurrency())
            .build();
        break;
      }
    }
    return price;
  }

  @Override
  public void updateOrder(Order newOrder) {
    Order foundOrder = findOrderByName(newOrder.getProduct().getName());
    if (foundOrder != null) {
      int idFromOrders = getIdFromOrders(foundOrder);

      newOrder.setStockPrice(getStockPrice(newOrder.getProduct()));

      Price totalPrice = calculateTotalPrice(newOrder.getProduct(), newOrder.getQuantity());
      newOrder.setTotalPrice(totalPrice);

      if (totalPrice instanceof SpecialPrice) {
        newOrder.setSpecialOffer(true);
      }

      if (isOutOfArray(idFromOrders)) {
        if (newOrder.getQuantity() > 0) {
          orders.set(idFromOrders, newOrder);
        } else {
          orders.remove(idFromOrders);
        }
      }

    }
  }

  private boolean isOutOfArray(int idFromOrders) {
    return idFromOrders > Integer.MIN_VALUE;
  }

  private int getIdFromOrders(Order order) {
    for (int i = 0; i < orders.size(); i++) {
      if (orders.get(i).equals(order)) {
        return i;
      }
    }

    return Integer.MIN_VALUE;
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
