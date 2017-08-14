package pl.koszela.jan.layer.model.service;

import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface ModelService {

  Item[] getItems();

  Price[] getStockPrices();

  SpecialPrice[] getSpecialPrices();
}
