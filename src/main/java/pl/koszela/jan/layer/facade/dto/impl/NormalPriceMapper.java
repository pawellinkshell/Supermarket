package pl.koszela.jan.layer.facade.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class NormalPriceMapper {

  public static NormalPriceDTO map(Price price) {
    NormalPriceDTO dto = new NormalPriceDTO();
    dto.setId(price.getId());
    dto.setPrice(price.getUnit());

    return dto;
  }

  public static Price map(NormalPriceDTO dto) {
    return new StockPrice(dto.getId(),
        dto.getPrice(),
        dto.getCurrency());
  }

  public static List<NormalPriceDTO> map(List<Price> prices) {
    List<NormalPriceDTO> dtos = new ArrayList<NormalPriceDTO>();

    for (Price price : prices) {
      dtos.add(map(price));
    }

    return dtos;
  }


  public static List<Price> productMap(List<NormalPriceDTO> dtos) {
    List<Price> prices = new ArrayList<Price>();

    for (NormalPriceDTO dto : dtos) {
      prices.add(map(dto));
    }

    return prices;
  }
}
