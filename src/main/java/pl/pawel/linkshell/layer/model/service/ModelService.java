package pl.pawel.linkshell.layer.model.service;

import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.SpecialPrice;

/**
 * Created on 14.08.2017.
 *
 */
public interface ModelService {

  Item getItem(String itemName);

  Item[] getItems();

  Price getStockPrice(int id);

  Price[] getStockPrices();

  SpecialPrice getSpecialPrice(int id, int quantity);

  SpecialPrice[] getSpecialPrices();
}
