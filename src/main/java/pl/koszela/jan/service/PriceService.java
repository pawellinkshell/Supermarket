package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.persistence.dto.impl.NormalPriceDTO;
import pl.koszela.jan.persistence.dto.impl.SpecialPriceDTO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceService {

  List<NormalPriceDTO> getNormalPrices();

  List<SpecialPriceDTO> getSpecialPrices();

}
