package pl.koszela.jan.persistence.dao;

import java.util.List;
import pl.koszela.jan.persistence.dto.SpecialPriceDTO;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface SpecialPriceDAO {
  List<SpecialPriceDTO> findAllItems();

  List<SpecialPriceDTO> findItemsByMultipricing(boolean isMultipricing);

  List<SpecialPriceDTO> findItemsByCurrency(String currency);
}
