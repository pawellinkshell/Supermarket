package pl.koszela.jan.layer.facade.mapper.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.facade.dto.impl.DefaultItemDTO;
import pl.koszela.jan.layer.facade.mapper.Mapper;
import pl.koszela.jan.layer.model.domain.impl.Item;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public class ItemMapper implements Mapper<Item, ItemDTO> {

  @Override
  public ItemDTO map(Item from) {
    ItemDTO dto = new DefaultItemDTO();
    dto.setId(from.getId());
    dto.setItem(from.getName());

    return dto;
  }

  @Override
  public List<ItemDTO> map(List<Item> items) {
    List<ItemDTO> dtos = new ArrayList<ItemDTO>();

    for (Item item : items) {
      dtos.add(map(item));
    }

    return dtos;
  }
}
