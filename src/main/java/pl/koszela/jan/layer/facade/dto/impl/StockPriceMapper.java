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
public class StockPriceMapper {

  public static StockPriceDTO map(Price price) {
    StockPriceDTO dto = new StockPriceDTO();
    dto.setId(price.getId());
    dto.setPrice(price.getUnit());

    return dto;
  }

  public static Price map(StockPriceDTO dto) {
    return new StockPrice(dto.getId(),
        dto.getPrice(),
        dto.getCurrency());
  }

  public static List<StockPriceDTO> map(List<Price> prices) {
    List<StockPriceDTO> dtos = new ArrayList<StockPriceDTO>();

    for (Price price : prices) {
      dtos.add(map(price));
    }

    return dtos;
  }


  public static List<Price> productMap(List<StockPriceDTO> dtos) {
    List<Price> prices = new ArrayList<Price>();

    for (StockPriceDTO dto : dtos) {
      prices.add(map(dto));
    }

    return prices;
  }
}
