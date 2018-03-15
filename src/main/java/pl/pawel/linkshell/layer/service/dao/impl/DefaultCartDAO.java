package pl.pawel.linkshell.layer.service.dao.impl;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.springframework.stereotype.Component;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;
import pl.pawel.linkshell.layer.service.dao.CartDAO;
import pl.pawel.linkshell.main.annotation.SessionScope;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Component("cartDAO")
@SessionScope
public class DefaultCartDAO implements CartDAO {

  private final Cart cart;

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

    if (isValidQuantity(order)) {
      return this.cart.addOrder(order);
    } else {
      return false;
    }
  }

  private void setCartCurrency(Order order) {
    if (this.cart.getCurrency() == null) {
      this.cart.setCurrency(order.getStockPrice().getCurrency());
    }
  }

  private boolean isValidQuantity(Order order) {
    return order.getQuantity() > 0;
  }

  @Override
  public boolean update(Order order) {
    setCartCurrency(order);

    if (isValidQuantity(order)) {
      return this.cart.updateOrder(order);
    } else {
      return false;
    }
  }

  @Override
  public boolean removeOrder(Order order) {
    for (Iterator<Order> i = this.cart.getOrders().iterator(); i.hasNext(); ) {
      if (Objects.equals(i.next().getItem(), order.getItem())) {
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
  public Cart getCart() {
    return this.cart;
  }

  @Override
  public String toString() {
    return "DefaultCartDAO{" +
        "cart=" + cart +
        '}';
  }
}
