package pl.koszela.jan.persistence.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductMapper {

  public static ProductDTO map(Product product) {
    DefaultProductDTO dto =  new DefaultProductDTO();
    dto.setId(product.getId());
    dto.setItem(product.getItem());
    dto.setUnitPrice(product.getUnitPrice());
    dto.setCurrency(product.getCurrency());
    dto.setMultipricing(product.isMultipricing());

    return dto;
  }

  public static Product map(ProductDTO dto) {
    return Product.builder()
        .id(dto.getId())
        .item(dto.getItem())
        .unitPrice(dto.getUnitPrice())
        .currency(dto.getCurrency())
        .multipricing(dto.isMultipricing())
        .build();
  }

  public static List<ProductDTO> map(List<Product> products) {
    List<ProductDTO> dtos = new ArrayList<ProductDTO>();

    for (Product product : products) {
      dtos.add(map(product));
    }

    return dtos;
  }

}
