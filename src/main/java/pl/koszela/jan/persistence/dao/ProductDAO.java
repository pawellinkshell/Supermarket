package pl.koszela.jan.persistence.dao;

import java.util.List;
import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface ProductDAO {
  List<ProductDTO> getAllItems();

  List<ProductDTO> getItemsByMultipricing(boolean isMultipricing);

  List<ProductDTO> getItemsByCurrency(String currency);
}
