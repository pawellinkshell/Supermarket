package pl.koszela.jan.layer.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Product;
import pl.koszela.jan.layer.model.converter.impl.JsonConverter;
import pl.koszela.jan.layer.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private Map<Product, Price> products;

  private final JsonConverter converter;

  public DefaultProductService() {
    converter = new JsonConverter(getSampleDataPath());
//    converter.convert();

    products = new HashMap<>();

//    for (Product product : DefaultProductMapper
//        .productMap(converter
//            .getProductList())) {
//      products.put(product,
//          getStockPrice(
//              product.getId()));
//    }

  }

  private Price getStockPrice(int id) {
//    for (Price price : NormalPriceMapper
//        .productMap(converter.getNormalPriceList())) {
//      if (price.getId() == id) {
//        return price;
//      }
//    }
    return null;
  }

  private String getSampleDataPath() {
    return getClass().getClassLoader().getResource("/").getPath() + "sample/";
  }

  @Override
  public Map<Product, Price> getProducts() {
    return this.products;
  }

  @Override
  public Product getProductById(int id) {
    for (Map.Entry<Product, Price> entry : products.entrySet()) {
      if (entry.getKey().getId() == id) {
        return entry.getKey();
      }
    }
    return null;
  }

  @Override
  public Product getProductByName(String productName) {
    for (Map.Entry<Product, Price> entry : products.entrySet()) {
      if (entry.getKey().getName().equals(productName)) {
        return entry.getKey();
      }
    }
    return null;
  }


  @Override
  public Price getPrice(Product product) {
    for (Map.Entry<Product, Price> entry : products.entrySet()) {
      if (entry.getKey().getName().equals(product.getName())) {
        return entry.getValue();
      }
    }
    return null;
  }
}
