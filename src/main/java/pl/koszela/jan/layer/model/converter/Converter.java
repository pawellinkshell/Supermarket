package pl.koszela.jan.layer.model.converter;

import pl.koszela.jan.layer.model.domain.impl.NormalPrice;
import pl.koszela.jan.layer.model.domain.impl.Product;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface Converter {

  Product[] convertProducts();

  SpecialPrice[] convertSpecialPrices();

  NormalPrice[] convertNormalPrices();

}
