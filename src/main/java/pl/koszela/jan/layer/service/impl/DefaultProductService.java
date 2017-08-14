package pl.koszela.jan.layer.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.service.ModelService;
import pl.koszela.jan.layer.service.ProductService;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
@Service("productService")
@DependsOn("modelService")
public class DefaultProductService implements ProductService {

  private Map<Item, Price> products;

  @Autowired
  private ModelService modelService;

  public DefaultProductService() {
    putProductsFromModel();
  }

  private void putProductsFromModel() {
    /*
     * We assume that the data's are ordered in model layer without lack of id's
     */

    products = new TreeMap<>();
    Item[] items = modelService.getItems();
    Price[] prices = modelService.getStockPrices();

    for (int i = 0; (i < items.length) && (i < prices.length); i++) {
      if (items[i].getId() == prices[i].getId()) {
        products.put(items[i], prices[i]);
      }
    }

    /*
     * Data should be loaded in order.
     * If will be some lack of data during loading in the "model layer",
     * that the "product service" should put only valid and matched data.
     */
//    Iterator<Item> items = Arrays.asList(modelService.getItems()).iterator();
//    Iterator<Price> prices = Arrays.asList(modelService.getStockPrices()).iterator();
//
//    while(items.hasNext() && prices.hasNext()){
//      Item item = items.next();
//      Price price = prices.next();
//      if (item.getId() == price.getId()) {
//        products.put(item, price);
//      }
//    }
  }

  @Override
  public Map<Item, Price> getProducts() {
    return this.products;
  }

  @Override
  public Item getProduct(int id) {
    for (Item item : products.keySet()) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  @Override
  public Item getProduct(String productName) {
    for (Item item : products.keySet()) {
      if (item.getName().equals(productName)) {
        return item;
      }
    }
    return null;
  }

  @Override
  public Price getPrice(Item item) {
    for (Price price : products.values()) {
      if (price.getId() == item.getId()) {
        return price;
      }
    }
    return null;
  }

  @Override
  public Price getPrice(int id) {
    for (Price price : products.values()) {
      if (price.getId() == id) {
        return price;
      }
    }
    return null;
  }

  @Override
  public Price getPrice(String productName) {
    for (Map.Entry<Item, Price> entry : products.entrySet()) {
      if (entry.getKey().getName().equals(productName)) {
        return entry.getValue();
      }
    }
    return null;
  }

  @Override
  public Price[] getStockPrices() {
    return modelService.getStockPrices();
  }

  @Override
  public List<Price> getListStockPrice() {
    return Arrays.asList(modelService.getStockPrices());
  }

}
