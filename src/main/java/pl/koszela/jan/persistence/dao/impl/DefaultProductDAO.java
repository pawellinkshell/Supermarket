package pl.koszela.jan.persistence.dao.impl;

import java.util.List;
import pl.koszela.jan.persistence.dao.ProductDAO;
import pl.koszela.jan.persistence.dto.ProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class DefaultProductDAO implements ProductDAO {

  @Override
  public List<ProductDTO> getAllItems() {
    return null;
  }

  @Override
  public List<ProductDTO> getItemsByMultipricing(boolean isMultipricing) {
    return null;
  }

  @Override
  public List<ProductDTO> getItemsByCurrency(String currency) {
    return null;
  }
}
