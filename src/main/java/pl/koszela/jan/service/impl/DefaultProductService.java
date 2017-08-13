package pl.koszela.jan.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.persistence.converter.JsonConverter;
import pl.koszela.jan.persistence.dto.impl.DefaultProductMapper;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private List<Product> products;

  public DefaultProductService() {
    JsonConverter converter = new JsonConverter(getSampleDataPath());
    converter.convert();

    products.addAll(
        DefaultProductMapper
            .productMap(converter.getProductList()));
  }

  private String getSampleDataPath() {
    return getClass().getClassLoader().getResource("/").getPath() + "sample/";
  }

  @Override
  public List<Product> getProducts() {
    return this.products;
  }

  @Override
  public Product getProductById(int id) {
    for (Product product : products) {
      if (product.getId() == id) {
        return product;
      }
    }
    return null;
  }

  @Override
  public Product getProductByName(String productName) {
    for (Product product : products) {
      if (product.getName().equals(productName)) {
        return product;
      }
    }
    return null;
  }
}
