package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceService {

  List<PriceDTO> getNormalPrices();
  List<PriceDTO> getSpecialPrices();

}
