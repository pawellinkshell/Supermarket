package pl.koszela.jan.layer.service.impl;

import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.converter.impl.JsonConverter;
import pl.koszela.jan.layer.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private Map<Item, Price> products;

  private final JsonConverter converter;

  public DefaultProductService() {

    converter = new JsonConverter(getSampleDataPath());
//    converter.convert();

    products = new HashMap<>();

    for (Item item : DefaultProductMapper
        .productMap(converter
            .getProductList())) {
      products.put(item,
          getStockPrice(
              item.getId()));
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
  public Map<Item, Price> getProducts() {
    return this.products;
  }

  @Override
  public Item getProductById(int id) {
    for (Map.Entry<Item, Price> entry : products.entrySet()) {
      if (entry.getKey().getId() == id) {
        return entry.getKey();
      }
    }
    return null;
  }

  @Override
  public Item getProductByName(String productName) {
    for (Map.Entry<Item, Price> entry : products.entrySet()) {
      if (entry.getKey().getName().equals(productName)) {
        return entry.getKey();
      }
    }
    return null;
  }


  @Override
  public Price getPrice(Item item) {
    for (Map.Entry<Item, Price> entry : products.entrySet()) {
      if (entry.getKey().getName().equals(item.getName())) {
        return entry.getValue();
      }
    }
    return null;
  }
}
