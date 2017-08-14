package pl.koszela.jan.layer.service.dao;

import java.util.List;
import pl.koszela.jan.layer.facade.dto.PriceDTO;

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
