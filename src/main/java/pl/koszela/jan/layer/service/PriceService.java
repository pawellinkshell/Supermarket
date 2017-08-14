package pl.koszela.jan.layer.service;

import java.util.List;
import pl.koszela.jan.layer.model.domain.impl.NormalPrice;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceService {

  List<NormalPrice> getNormalPrices();

  List<SpecialPrice> getSpecialPrices();

}
