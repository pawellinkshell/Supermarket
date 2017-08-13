package pl.koszela.jan.persistence.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class NormalPriceMapper {

  public static PriceDTO map(Price price) {
    NormalPriceDTO dto = new NormalPriceDTO();
    dto.setId(price.getId());
    dto.setPrice(price.getUnit());

    return dto;
  }

  public static Price map(PriceDTO dto) {
    return NormalPrice.builder()
        .id(dto.getId())
        .price(dto.getPrice())
        .currency(dto.getCurrency())
        .build();
  }

  public static List<PriceDTO> map(List<Price> prices) {
    List<PriceDTO> dtos = new ArrayList<PriceDTO>();

    for (Price price : prices) {
      dtos.add(map(price));
    }

    return dtos;
  }


  public static List<Price> productMap(List<PriceDTO> dtos) {
    List<Price> prices = new ArrayList<Price>();

    for (PriceDTO dto : dtos) {
      prices.add(map(dto));
    }

    return prices;
  }
}
