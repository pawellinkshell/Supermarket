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

  private List<PriceDTO> specialPrices;

  @Override
  public List<PriceDTO> getPrices() {
    return this.specialPrices;
  }

  @Override
  public void setSpecialPrices(List<PriceDTO> specialPrices) {
    this.specialPrices = specialPrices;
  }

  @Override
  public String toString() {
    return "DefaultPriceListDTO{\n" +
        "specialPrices=" + specialPrices +
        "\n}";
  }
}
