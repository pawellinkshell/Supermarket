package pl.koszela.jan.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.persistence.converter.JsonConverter;
import pl.koszela.jan.persistence.dto.impl.NormalPriceDTO;
import pl.koszela.jan.persistence.dto.impl.SpecialPriceDTO;
import pl.koszela.jan.service.PriceService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("priceService")
public class DefaultPriceService implements PriceService {

  private JsonConverter converter;

  public DefaultPriceService() {
    this.converter = new JsonConverter(getSampleDataPath());
    converter.convert();
  }

  private String getSampleDataPath() {
    return getClass().getClassLoader().getResource("/").getPath() + "sample/";
  }

  @Override
  public List<NormalPriceDTO> getNormalPrices() {
    return converter.getNormalPriceList();
  }

  @Override
  public List<SpecialPriceDTO> getSpecialPrices() {
    return converter.getSpecialPriceList();
  }
}
