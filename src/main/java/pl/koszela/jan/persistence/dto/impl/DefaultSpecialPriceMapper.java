package pl.koszela.jan.persistence.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.dto.SpecialPriceDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultSpecialPriceMapper {

  public static SpecialPriceDTO map(SpecialPrice specialPrice) {
    DefaultSpecialPriceDTO dto =  new DefaultSpecialPriceDTO();
    dto.setId(specialPrice.getId());
    dto.setAmount(specialPrice.getAmount());
    dto.setPrice(specialPrice.getPrice());

    return dto;
  }

  public static List<SpecialPriceDTO> map(List<SpecialPrice> specialPrices) {
    List<SpecialPriceDTO> dtos = new ArrayList<SpecialPriceDTO>();

    for (SpecialPrice specialPrice : specialPrices) {
      dtos.add(map(specialPrice));
    }

    return dtos;
  }
}
