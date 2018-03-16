package pl.pawel.linkshell.layer.facade.impl;

import java.util.Map;
import java.util.TreeMap;
import org.springframework.beans.factory.annotation.Autowired;
import pl.pawel.linkshell.layer.facade.ProductFacade;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;
import pl.pawel.linkshell.layer.facade.mapper.Mapper;
import pl.pawel.linkshell.layer.facade.mapper.impl.Maps;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.service.ProductService;
import pl.pawel.linkshell.main.annotation.Facade;

/**
 * Created on 15.08.2017.
 *
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

      for (Map.Entry<Item, Price> entry : productService.getProducts().entrySet()) {
        products.put((ItemDTO) items.map(entry.getKey()),
            (PriceDTO) prices.map(entry.getValue()));
      }
    }

    return products;
  }
}
