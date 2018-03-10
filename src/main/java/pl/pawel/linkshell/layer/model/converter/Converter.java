package pl.pawel.linkshell.layer.model.converter;

import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.SpecialPrice;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;

/**
 * Created on 14.08.2017.
 *
 */
public interface Converter {

  Item[] convertItems();

  SpecialPrice[] convertSpecialPrices();

  StockPrice[] convertNormalPrices();

}
