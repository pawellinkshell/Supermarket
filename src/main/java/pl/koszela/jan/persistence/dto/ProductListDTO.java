package pl.koszela.jan.persistence.dto;

import java.util.List;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public interface ProductListDTO {

  List<ProductDTO> getProducts();

  void setProducts(List<ProductDTO> products);

}
