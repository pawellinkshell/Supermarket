package pl.koszela.jan.persistence.dto.impl;

import java.util.List;
import pl.koszela.jan.persistence.dto.PriceDTO;
import pl.koszela.jan.persistence.dto.PriceListDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultPriceListDTO implements PriceListDTO {

  private List<PriceDTO> priceDTOS;

  @Override
  public List<PriceDTO> getPrices() {
    return this.priceDTOS;
  }

  @Override
  public void setPrices(List<PriceDTO> specialPrices) {
    this.priceDTOS = specialPrices;
  }


  @Override
  public String toString() {
    return "DefaultPriceListDTO{\n" +
        "priceDTOS=" + priceDTOS +
        "\n}";
  }
}
