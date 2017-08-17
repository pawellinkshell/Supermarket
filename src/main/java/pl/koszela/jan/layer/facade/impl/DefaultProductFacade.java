package pl.koszela.jan.layer.facade.impl;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import pl.koszela.jan.layer.facade.ProductFacade;
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.facade.dto.PriceDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;
import pl.koszela.jan.layer.facade.mapper.impl.Maps;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.service.ProductService;
import pl.koszela.jan.main.annotation.Facade;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
@Facade("productFacade")
public class DefaultProductFacade implements ProductFacade {

  private Map<ItemDTO, PriceDTO> products;

  @Autowired
  private ProductService productService;

  @Override
  public Map<ItemDTO, PriceDTO> getProducts() {

    if ((products == null) ||
        (products.hashCode() != productService.getProducts().hashCode())) {
      products = new TreeMap<>();

      Mapper items = Maps.getMapper(ItemDTO.class);
      Mapper prices = Maps.getMapper(PriceDTO.class);

      for (java.util.Map.Entry<Item, Price> entry : productService.getProducts().entrySet()) {
        products.put((ItemDTO) items.map(entry.getKey()),
            (PriceDTO) prices.map(entry.getValue()));
      }
    }

    return products;
  }
}
