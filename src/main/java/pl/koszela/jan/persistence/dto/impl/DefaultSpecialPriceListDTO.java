package pl.koszela.jan.persistence.dto.impl;

import java.util.List;
import pl.koszela.jan.persistence.dto.SpecialPriceDTO;
import pl.koszela.jan.persistence.dto.SpecialPriceListDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultSpecialPriceListDTO implements SpecialPriceListDTO {

  private List<SpecialPriceDTO> specialPrices;

  @Override
  public List<SpecialPriceDTO> getSpecialPrices() {
    return this.specialPrices;
  }

  @Override
  public void setSpecialPrices(List<SpecialPriceDTO> specialPrices) {
    this.specialPrices = specialPrices;
  }
}
