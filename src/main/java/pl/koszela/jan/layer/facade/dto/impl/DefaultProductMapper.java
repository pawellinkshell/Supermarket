package pl.koszela.jan.layer.facade.dto.impl;

import java.util.ArrayList;
import java.util.List;
import pl.koszela.jan.layer.model.domain.impl.Product;
import pl.koszela.jan.layer.facade.dto.ProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductMapper {

  public static ProductDTO map(Product product) {
    DefaultProductDTO dto = new DefaultProductDTO();
    dto.setId(product.getId());
    dto.setItem(product.getName());
    dto.setMultipricing(product.isMultipricing());

    return dto;
  }

  public static Product map(ProductDTO dto) {
    return new Product(dto.getId(), dto.getItem(), dto.isMultipricing());
  }

  public static List<ProductDTO> map(List<Product> products) {
    List<ProductDTO> dtos = new ArrayList<ProductDTO>();

    for (Product product : products) {
      dtos.add(map(product));
    }

    return dtos;
  }

  public static List<Product> productMap(List<ProductDTO> dtos) {
    List<Product> products = new ArrayList<Product>();

    for (ProductDTO dto : dtos) {
      products.add(map(dto));
    }

    return products;
  }

}
