package pl.koszela.jan.persistence.dao;

import java.util.List;
import pl.koszela.jan.persistence.dto.PriceDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceDAO {
  List<PriceDTO> findAllItems();

  List<PriceDTO> findItemsByMultipricing(boolean isMultipricing);

  List<PriceDTO> findItemsByCurrency(String currency);
}
