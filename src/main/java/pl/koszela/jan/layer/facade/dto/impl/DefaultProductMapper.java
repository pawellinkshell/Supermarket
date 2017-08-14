package pl.koszela.jan.layer.facade.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.facade.dto.ProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductMapper {

  public static ProductDTO map(Item item) {
    DefaultProductDTO dto = new DefaultProductDTO();
    dto.setId(item.getId());
    dto.setItem(item.getName());
    dto.setMultipricing(item.isMultipricing());

    return dto;
  }

  public static Item map(ProductDTO dto) {
    return new Item(dto.getId(), dto.getItem(), dto.isMultipricing());
  }

  public static List<ProductDTO> map(List<Item> items) {
    List<ProductDTO> dtos = new ArrayList<ProductDTO>();

    for (Item item : items) {
      dtos.add(map(item));
    }

    return dtos;
  }

  public static List<Item> productMap(List<ProductDTO> dtos) {
    List<Item> items = new ArrayList<Item>();

    for (ProductDTO dto : dtos) {
      items.add(map(dto));
    }

    return items;
  }

}
