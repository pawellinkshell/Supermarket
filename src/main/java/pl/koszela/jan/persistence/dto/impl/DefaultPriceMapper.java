package pl.koszela.jan.persistence.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultPriceMapper {

  public static PriceDTO map(SpecialPrice specialPrice) {
    DefaultPriceDTO dto =  new DefaultPriceDTO();
    dto.setId(specialPrice.getId());
    dto.setAmount(specialPrice.getAmount());
    dto.setPrice(specialPrice.getPrice());

    return dto;
  }

  public static List<PriceDTO> map(List<SpecialPrice> specialPrices) {
    List<PriceDTO> dtos = new ArrayList<PriceDTO>();

    for (SpecialPrice specialPrice : specialPrices) {
      dtos.add(map(specialPrice));
    }

    return dtos;
  }
}
