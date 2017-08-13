package pl.koszela.jan.persistence.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultPriceMapper {

  public static PriceDTO map(Price price) {
    DefaultPriceDTO dto = new DefaultPriceDTO();
    dto.setId(price.getId());
    dto.setPrice(price.getPrice());

    return dto;
  }

  public static List<PriceDTO> map(List<Price> prices) {
    List<PriceDTO> dtos = new ArrayList<PriceDTO>();

    for (Price price : prices) {
      dtos.add(map(price));
    }

    return dtos;
  }
}
