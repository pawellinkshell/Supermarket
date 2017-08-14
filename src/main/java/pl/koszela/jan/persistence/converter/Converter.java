package pl.koszela.jan.persistence.converter;

import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;

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
