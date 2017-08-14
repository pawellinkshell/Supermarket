package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.SpecialPrice;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceService {

  List<NormalPrice> getNormalPrices();

  List<SpecialPrice> getSpecialPrices();

}
