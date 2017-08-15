package pl.koszela.jan.layer.facade.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.model.domain.impl.Item;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductMapper {

  public static ItemDTO map(Item item) {
    DefaultItemDTO dto = new DefaultItemDTO();
    dto.setId(item.getId());
    dto.setItem(item.getName());
    dto.setMultipricing(item.isMultipricing());

    return dto;
  }

  public static Item map(ItemDTO dto) {
    return new Item(dto.getId(), dto.getItem(), dto.isMultipricing());
  }

  public static List<ItemDTO> map(List<Item> items) {
    List<ItemDTO> dtos = new ArrayList<ItemDTO>();

    for (Item item : items) {
      dtos.add(map(item));
    }

    return dtos;
  }

  public static List<Item> productMap(List<ItemDTO> dtos) {
    List<Item> items = new ArrayList<Item>();

    for (ItemDTO dto : dtos) {
      items.add(map(dto));
    }

    return items;
  }

}
