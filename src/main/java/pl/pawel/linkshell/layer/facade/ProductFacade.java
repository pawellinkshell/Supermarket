package pl.pawel.linkshell.layer.facade;

import java.util.Map;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;

/**
 * Created on 15.08.2017.
 *
 */
public interface ProductFacade {

  Map<ItemDTO, PriceDTO> getProducts();
}
