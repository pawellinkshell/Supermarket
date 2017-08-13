package pl.koszela.jan.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import pl.koszela.jan.domain.Price;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.persistence.converter.JsonConverter;
import pl.koszela.jan.persistence.dto.impl.DefaultProductMapper;
import pl.koszela.jan.persistence.dto.impl.NormalPriceMapper;
import pl.koszela.jan.service.PriceService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private Map<Product, Price> products;

  @Autowired
  private PriceService priceService;
  private final JsonConverter converter;

  public DefaultProductService() {
    converter = new JsonConverter(getSampleDataPath());
    converter.convert();

    products = new HashMap<>();

    for (Product product : DefaultProductMapper
        .productMap(converter
            .getProductList())) {
      products.put(product,
          getStockPrice(
              product.getId()));
    }

  }

  private Price getStockPrice(int id) {
    for (Price price : NormalPriceMapper
        .productMap(converter.getNormalPriceList())) {
      if (price.getId() == id) {
        return price;
      }
    }
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
