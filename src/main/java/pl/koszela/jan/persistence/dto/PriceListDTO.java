package pl.koszela.jan.persistence.dto;

import java.util.List;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceListDTO {

  List<PriceDTO> getPrices();

  void setPrices(List<PriceDTO> prices);
}
