package pl.koszela.jan.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.service.ModelService;
import pl.koszela.jan.service.PriceService;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@Service("priceService")
public class DefaultPriceService implements PriceService {

  @Autowired
  private ModelService modelService;

  @Override
  public List<NormalPrice> getNormalPrices() {
    return Arrays.asList(modelService.getNormalPrices());
  }

  @Override
  public List<SpecialPrice> getSpecialPrices() {
    return Arrays.asList(modelService.getSpecialPrices());
  }
}
