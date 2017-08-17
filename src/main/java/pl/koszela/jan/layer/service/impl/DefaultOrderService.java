package pl.koszela.jan.layer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;
import pl.koszela.jan.layer.model.service.ModelService;
import pl.koszela.jan.layer.service.OrderService;
import pl.koszela.jan.layer.service.dao.OrderDAO;
import pl.koszela.jan.main.annotation.SessionScope;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("orderService")
@SessionScope
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
  public boolean createOrder(String product, int quantity) {
    Order order = getBaseOrder(product, quantity);
    if (isValidQuantity(quantity)) {

      order = setOrderPricing(order, quantity);

      return orderDAO.addOrder(order);
    } else {
      if (removeOrder(order)) {
        return false;
      }
    }

    return false;
  }

  private Order setOrderPricing(Order order, int quantity) {
    Price totalPrice = calculateTotalPrice(order.getItem(), quantity);
    order.setTotalPrice(totalPrice);
    order.setSpecialOffer(isSpecialOffer(totalPrice));

    return order;
  }

  private Order getBaseOrder(String productName, int quantity) {
    Order order = new Order();
    Item item = modelService.getItem(productName);

    order.setItem(item);
    order.setQuantity(quantity);
    order.setStockPrice(getStockPrice(item));

    return order;
  }

  private boolean isValidQuantity(int quantity) {
    return quantity > 0;
  }

  private Price getStockPrice(Item item) {
    return modelService.getStockPrice(item.getId());
  }

  private Price calculateTotalPrice(Item item, int quantity) {
    Price price = getSpecialPrice(item, quantity);

    if (price == null) {
      price = getStockPrice(item);
      price.setUnit(price.getUnit() * quantity);
    }

    return price;
  }

  private boolean isSpecialOffer(Price totalPrice) {
    return (totalPrice instanceof SpecialPrice) ? true : false;
  }

  private Price getSpecialPrice(Item item, int quantity) {
    return modelService.getSpecialPrice(item.getId(), quantity);
  }

  @Override
  public boolean updateOrder(String product, int quantity) {
    Order foundOrder = orderDAO.findOrderByName(product);

    if (foundOrder != null) {
      foundOrder = setOrderPricing(foundOrder, quantity);

      int orderId = orderDAO.findId(foundOrder);

      if (isValidQuantity(quantity) &&
          isValidId(orderId)) {
        foundOrder.setQuantity(quantity);
        return orderDAO.updateOrder(orderId, foundOrder);       // (P && Q)
      } else {
        return orderDAO.removeOrder(orderId);                   // (!Q && P) Commutative property
      }

//      if (isValidId(orderId)) {
//        if (isValidQuantity(order)) {
//          return orderDAO.updateOrder(orderId, order);        // (P && Q)
//        } else {
//          return orderDAO.removeOrder(orderId);               // (P && !Q)
//        }
//      }
    }

    return false;
  }

  @Override
  public boolean removeOrder(Order order) {
    int orderId = orderDAO.findId(order);
    if (isValidId(orderId)) {
      return orderDAO.removeOrder(orderId);
    }
    return false;
  }

  private boolean isValidId(int idFromOrders) {
    return idFromOrders >= 0;
  }

}
