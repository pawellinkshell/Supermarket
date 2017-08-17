package pl.koszela.jan.layer.facade.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.facade.dto.PriceDTO;
import pl.koszela.jan.layer.facade.dto.impl.StockPriceDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;
import pl.koszela.jan.layer.model.domain.Price;

/**
 * Created on 16.08.2017.
 *
 * @author Jan Koszela
 */
public class StockPriceMapper implements Mapper<Price, PriceDTO> {

  @Override
  public PriceDTO map(Price from) {
    PriceDTO dto = new StockPriceDTO();
    dto.setId(from.getId());
    dto.setUnit(from.getUnit());
    dto.setCurrency(from.getCurrency());

    return dto;
  }

  @Override
  public List<PriceDTO> map(List<Price> prices) {
    List<PriceDTO> dtos = new ArrayList<PriceDTO>();

    for (Price item : prices) {
      dtos.add(map(item));
    }

    return dtos;
  }
}
