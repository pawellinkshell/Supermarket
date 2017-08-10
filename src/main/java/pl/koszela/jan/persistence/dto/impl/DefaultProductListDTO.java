package pl.koszela.jan.persistence.dto.impl;

import java.util.List;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.ProductListDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductListDTO implements ProductListDTO {

  private List<ProductDTO> products;

  @Override
  public List<ProductDTO> getProducts() {
    return this.products;
  }

  @Override
  public void setProducts(List<ProductDTO> products) {
    this.products = products;
  }

  @Override
  public String toString() {
    return "DefaultProductListDTO{\n" +
        "products=" + products +
        "\n}";
  }
}
