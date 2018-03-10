package pl.pawel.linkshell.layer.model.service.impl;

import org.springframework.stereotype.Service;
import pl.pawel.linkshell.layer.model.converter.Converter;
import pl.pawel.linkshell.layer.model.converter.impl.JsonConverter;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.SpecialPrice;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;
import pl.pawel.linkshell.layer.model.service.ModelService;

/**
 * Created on 14.08.2017.
 *
 */
@Service("modelService")
public class DefaultModelService implements ModelService {

  private Converter converter;

  public DefaultModelService() {
    this.converter = new JsonConverter();
  }

  @Override
  public Item getItem(String itemName) {
    Item[] items = getItems();
    for (int i = 0; i < items.length; i++) {
      if (items[i].getName().equals(itemName)) {
        return items[i];
      }
    }

    return null;
  }

  @Override
  public Item[] getItems() {
    return this.converter.convertItems();
  }

  @Override
  public Price getStockPrice(int id) {
    Price[] prices = getStockPrices();
    for (int i = 0; i < prices.length; i++) {
      if (prices[i].getId() == id) {
        return prices[i];
      }
    }

    return null;
  }

  @Override
  public StockPrice[] getStockPrices() {
    return this.converter.convertNormalPrices();
  }

  @Override
  public SpecialPrice getSpecialPrice(int id, int quantity) {
    SpecialPrice[] prices = getSpecialPrices();
    for (int i = 0; i < prices.length; i++) {
      if ( isSpecialPrice(prices[i], id, quantity)) {
        return prices[i];
      }
    }

    return null;
  }

  private boolean isSpecialPrice(SpecialPrice price, int id, int quantity) {
    return (price.getId() == id) && (price.getAmount() == quantity);
  }

  @Override
  public SpecialPrice[] getSpecialPrices() {
    return this.converter.convertSpecialPrices();
  }
}
