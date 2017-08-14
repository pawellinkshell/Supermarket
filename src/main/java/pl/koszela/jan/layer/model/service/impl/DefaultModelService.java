package pl.koszela.jan.layer.model.service.impl;

import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.SpecialPrice;
import pl.koszela.jan.layer.model.converter.Converter;
import pl.koszela.jan.layer.model.converter.impl.JsonConverter;
import pl.koszela.jan.layer.model.service.ModelService;

/**
 * Created on 14.08.2017.
 *
 * @author Jan Koszela
 */
@Service("modelService")
public class DefaultModelService implements ModelService {

  private Converter converter;

  public DefaultModelService() {
    this.converter = new JsonConverter();
  }

  @Override
  public Item[] getItems() {
    return this.converter.convertItems();
  }

  @Override
  public StockPrice[] getStockPrices() {
    return this.converter.convertNormalPrices();
  }

  @Override
  public SpecialPrice[] getSpecialPrices() {
    return this.converter.convertSpecialPrices();
  }
}
