package pl.koszela.jan.service.impl;

import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.converter.Converter;
import pl.koszela.jan.persistence.converter.impl.JsonConverter;
import pl.koszela.jan.service.ModelService;

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
  public Product[] getProducts() {
    return this.converter.convertProducts();
  }

  @Override
  public NormalPrice[] getNormalPrices() {
    return this.converter.convertNormalPrices();
  }

  @Override
  public SpecialPrice[] getSpecialPrices() {
    return this.converter.convertSpecialPrices();
  }
}
