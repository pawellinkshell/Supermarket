package pl.koszela.jan.layer.facade;

import java.util.Map;
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.facade.dto.PriceDTO;

/**
 * Created on 15.08.2017.
 *
 * @author Jan Koszela
 */
public interface ProductFacade {

  Map<ItemDTO, PriceDTO> getProducts();
}
