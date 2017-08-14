package pl.koszela.jan.layer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;
import pl.koszela.jan.layer.model.service.ModelService;
import pl.koszela.jan.layer.service.OrderService;
import pl.koszela.jan.layer.service.dao.OrderDAO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("orderService")
public class DefaultOrderService implements OrderService {

  @Autowired
  private ModelService modelService;

  @Autowired
  private OrderDAO orderDAO;

  @Override
  public Order getOrderByName(String productName) {
    return orderDAO.findOrderByName(productName);
  }

  @Override
  public boolean createOrder(Order order) {
    if (isValidQuantity(order)) {
      fillByPrices(order);
      return orderDAO.addOrder(order);
    } else {
      if (removeOrder(order)) {
        return false;
      }
    }

    return false;
  }

  private boolean isValidQuantity(Order order) {
    return order.getQuantity() > 0;
  }

  private void fillByPrices(Order order) {
    order.setStockPrice(getStockPrice(order.getItem()));

    Price totalPrice = calculateTotalPrice(order.getItem(), order.getQuantity());
    if (totalPrice instanceof SpecialPrice) {
      order.setSpecialOffer(true);
    }
    order.setTotalPrice(totalPrice);
  }

  private Price getStockPrice(Item item) {
    Price resultPrice = null;

    for (Price price : modelService.getStockPrices()) {
      if (price.getId() == item.getId()) {
        resultPrice = new StockPrice(
            price.getId(),
            price.getUnit(),
            price.getCurrency());
        break;
      }
    }
    return resultPrice;
  }

  private Price calculateTotalPrice(Item item, int quantity) {
    Price price = getSpecialPrice(item, quantity);

    if (price == null) {
      price = getStockPrice(item);
      price.setUnit(price.getUnit() * quantity);
    }

    return price;
  }

  private Price getSpecialPrice(Item item, int quantity) {
    Price resultPrice = null;

    for (SpecialPrice price : modelService.getSpecialPrices()) {
      if (price.getId() == item.getId() &&
          price.getAmount() == quantity) {
        resultPrice = new SpecialPrice(price.getId(),
            price.getAmount(),
            price.getUnit(),
            price.getCurrency());
        break;
      }
    }

    return resultPrice;
  }

  @Override
  public boolean updateOrder(Order order) {
    Order foundOrder = orderDAO.findOrderByName(order.getItem().getName());

    if (foundOrder != null) {
      fillByPrices(order);

      int orderId = orderDAO.findId(foundOrder);

      if (isValidQuantity(order) &&
          isValidId(orderId)) {
        return orderDAO.updateOrder(orderId, order);      // (P && Q)
      } else {
        return orderDAO.removeOrder(orderId);             // (!Q && P) Commutative property
      }

//      if (isValidId(orderId)) {
//        if (isValidQuantity(order)) {
//          return orderDAO.updateOrder(orderId, order);  // (P && Q)
//        } else {
//          return orderDAO.removeOrder(orderId);         // (P && !Q)
//        }
//      }
    }

    return false;
  }

  @Override
  public boolean removeOrder(Order order) {
    int orderId = orderDAO.findId(order);
    if (isValidId(orderId)) {
      orderDAO.removeOrder(orderId);
      return true;
    }
    return false;
  }

  private boolean isValidId(int idFromOrders) {
    return idFromOrders >= 0;
  }
  
}
