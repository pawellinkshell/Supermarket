package pl.koszela.jan.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.persistence.converter.JsonConverter;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private JsonConverter converter;

  public DefaultProductService() {
    this.converter = new JsonConverter(getSampleDataPath());
    converter.convert();
  }

  private String getSampleDataPath() {
    return getClass().getClassLoader().getResource("/").getPath() + "sample/";
  }

  @Override
  public List<ProductDTO> getProducts() {
    return converter.getProductList();
  }
}
