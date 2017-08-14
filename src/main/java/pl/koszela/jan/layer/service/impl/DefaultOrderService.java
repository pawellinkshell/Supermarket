package pl.koszela.jan.layer.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Product;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;
import pl.koszela.jan.layer.facade.dto.impl.DefaultOrderDTO;
import pl.koszela.jan.layer.service.OrderService;
import pl.koszela.jan.layer.service.PriceService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("orderService")
public class DefaultOrderService implements OrderService {

  private static List<DefaultOrderDTO> orderDTOS;

  @Autowired
  PriceService priceService;

  public DefaultOrderService() {
    this.orderDTOS = new ArrayList<>();
  }

  @Override
  public DefaultOrderDTO findOrderByName(String productName) {
    for (Iterator<DefaultOrderDTO> i = orderDTOS.iterator(); i.hasNext(); ) {
      DefaultOrderDTO currentOrderDTO = i.next();
      if (isSameProduct(productName, currentOrderDTO)) {
        return currentOrderDTO;
      }
    }
    return null;
  }

  private boolean isSameProduct(String productName, DefaultOrderDTO currentOrderDTO) {
    return productName.equals(currentOrderDTO.getProduct().getName());
  }

  @Override
  public boolean createOrder(DefaultOrderDTO orderDTO) {
    if (orderDTO.getQuantity() > 0) {
      orderDTO.setStockPrice(getStockPrice(orderDTO.getProduct()));

      Price totalPrice = calculateTotalPrice(orderDTO.getProduct(), orderDTO.getQuantity());
      orderDTO.setTotalPrice(totalPrice);

      if (totalPrice instanceof SpecialPrice) {
        orderDTO.setSpecialOffer(true);
      }

      return this.orderDTOS.add(orderDTO);

    } else {

      int idFromOrders = getIdFromOrders(orderDTO);
      if (idFromOrders > Integer.MIN_VALUE) {
        orderDTOS.remove(idFromOrders);
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

//    for (SpecialPriceDTO dto : priceService.getSpecialPrices()) {
//      if (dto.getId() == product.getId() &&
//          dto.getAmount() == quantity) {
//        price = new SpecialPrice(dto.getId(),
//            dto.getAmount(),
//            dto.getPrice(),
//            dto.getCurrency());
//        break;
//      }
//    }
    return price;
  }

  private Price getStockPrice(Product product) {
    Price price = null;

//    for (PriceDTO dto : priceService.getNormalPrices()) {
//      if (dto.getId() == product.getId()) {
//        price = new NormalPrice(dto.getId(),
//            dto.getPrice(),
//            dto.getCurrency());
//        break;
//      }
//    }
    return price;
  }

  @Override
  public void updateOrder(DefaultOrderDTO newOrderDTO) {
    DefaultOrderDTO foundOrderDTO = findOrderByName(newOrderDTO.getProduct().getName());
    if (foundOrderDTO != null) {
      int idFromOrders = getIdFromOrders(foundOrderDTO);

      newOrderDTO.setStockPrice(getStockPrice(newOrderDTO.getProduct()));

      Price totalPrice = calculateTotalPrice(newOrderDTO.getProduct(), newOrderDTO.getQuantity());
      newOrderDTO.setTotalPrice(totalPrice);

      if (totalPrice instanceof SpecialPrice) {
        newOrderDTO.setSpecialOffer(true);
      }

      if (isOutOfArray(idFromOrders)) {
        if (newOrderDTO.getQuantity() > 0) {
          orderDTOS.set(idFromOrders, newOrderDTO);
        } else {
          orderDTOS.remove(idFromOrders);
        }
      }

    }
  }

  private boolean isOutOfArray(int idFromOrders) {
    return idFromOrders > Integer.MIN_VALUE;
  }

  private int getIdFromOrders(DefaultOrderDTO orderDTO) {
    for (int i = 0; i < orderDTOS.size(); i++) {
      if (orderDTOS.get(i).equals(orderDTO)) {
        return i;
      }
    }

    return Integer.MIN_VALUE;
  }

  @Override
  public boolean removeOrder(DefaultOrderDTO orderDTO) {
    DefaultOrderDTO foundOrderDTO = findOrderByName(orderDTO.getProduct().getName());
    if (foundOrderDTO != null) {
      orderDTOS.remove(getIdFromOrders(foundOrderDTO));

      return true;
    }
    return false;
  }

}
