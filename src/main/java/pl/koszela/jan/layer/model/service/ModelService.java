package pl.koszela.jan.layer.model.service;

import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.NormalPrice;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface ModelService {

  Item[] getItems();

  NormalPrice[] getNormalPrices();

  SpecialPrice[] getSpecialPrices();
}
