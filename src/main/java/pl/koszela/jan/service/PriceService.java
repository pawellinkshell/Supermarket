package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.domain.Price;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceService {

  List<Price> getPrices();

}
