package pl.koszela.jan.layer.service.dao.impl;

import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.facade.dto.impl.DefaultOrderDTO;
import pl.koszela.jan.layer.model.domain.impl.Cart;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;
import pl.koszela.jan.layer.service.dao.CartDAO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Component("cartDAO")
public class DefaultCartDAO implements CartDAO {

  private Cart cart;

  public DefaultCartDAO() {
    this.cart = new Cart();
  }

  @Override
  public List<Order> getOrdersFromCart() {
    return this.cart.getOrders();
  }

  @Override
  public boolean add(Order order) {
    setCartCurrency(order);
    removeOrderIfExists(order);

    if (isValidQuantity(order)) {
      return this.cart.addOrder(order);
    } else {
      return false;
    }
  }

  private void setCartCurrency(Order order) {
    if (this.cart.getCurrency() != null) {
      this.cart.setCurrency(order.getStockPrice().getCurrency());
    }
  }

  private void removeOrderIfExists(Order order) {
    if (isOrderExistsInCart(order)) {
      removeOrder(order);
    }
  }

  private boolean isOrderExistsInCart(Order order) {
    return this.cart.getOrders().contains(order);
  }

  private boolean isValidQuantity(Order order) {
    return order.getQuantity() > 0;
  }

  @Override
  public boolean removeOrder(Order order) {
    for (Iterator<Order> i = this.cart.getOrders().iterator(); i.hasNext(); ) {
      if (i.next().getItem() == order.getItem()) {
        i.remove();
        return true;
      }
    }

    return false;
  }

  @Override
  public Price getPrice() {
    return new StockPrice(0, this.cart.getPrice(), this.cart.getCurrency());
  }

  @Override
  public String toString() {
    return "DefaultCartDAO{" +
        "cart=" + cart +
        '}';
  }
}
