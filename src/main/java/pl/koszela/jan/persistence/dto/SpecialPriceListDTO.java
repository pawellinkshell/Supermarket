package pl.koszela.jan.persistence.dto;

import java.util.List;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public interface SpecialPriceListDTO {

  List<SpecialPriceDTO> getSpecialPrices();

  void setSpecialPrices(List<SpecialPriceDTO> specialPrices);
}
