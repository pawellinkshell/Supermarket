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

  private final Converter converter;

  public DefaultModelService() {
    this.converter = new JsonConverter();
  }

  @Override
  public Item getItem(String itemName) {
    for (Item item : getItems()) {
      if (item.getName().equals(itemName)) {
        return item;
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
    for (Price price : getStockPrices()) {
      if (price.getId() == id) {
        return price;
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
    for (SpecialPrice price : getSpecialPrices()) {
      if (isSpecialPrice(price, id, quantity)) {
        return price;
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
