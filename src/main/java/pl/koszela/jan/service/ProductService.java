package pl.koszela.jan.service;

import java.util.List;
import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public interface ProductService {

  List<ProductDTO> getProducts();
}
