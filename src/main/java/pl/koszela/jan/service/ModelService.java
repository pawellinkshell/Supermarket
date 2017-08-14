package pl.koszela.jan.service;

import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
public interface ModelService {

  Product[] getProducts();

  NormalPrice[] getNormalPrices();

  SpecialPrice[] getSpecialPrices();
}
