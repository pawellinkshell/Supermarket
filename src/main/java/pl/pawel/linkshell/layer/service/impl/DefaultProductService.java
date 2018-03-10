package pl.pawel.linkshell.layer.service.impl;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.service.ModelService;
import pl.pawel.linkshell.layer.service.ProductService;

/**
 * Created on 12.08.2017.
 */
@Service("productService")
public class DefaultProductService implements ProductService {

  private Map<Item, Price> products;

  @Autowired
  private ModelService modelService;

  @PostConstruct
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

  }

  @Override
  public Map<Item, Price> getProducts() {
    return this.products;
  }

  @Override
  public Item getItem(int id) {
    for (Item item : products.keySet()) {
      if (item.getId() == id) {
        return item;
      }
    }
    return null;
  }

  @Override
  public Item getItem(String name) {
    for (Item item : products.keySet()) {
      if (item.getName().equals(name)) {
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

  @Override
  public Item[] getItems() {
    return modelService.getItems();
  }

  @Override
  public List<Item> getItemList() {
    return Arrays.asList(modelService.getItems());
  }
}
