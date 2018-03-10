package pl.pawel.linkshell.layer.facade.impl;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;
import pl.pawel.linkshell.layer.facade.dto.impl.DefaultItemDTO;
import pl.pawel.linkshell.layer.facade.dto.impl.StockPriceDTO;
import pl.pawel.linkshell.layer.service.ProductService;

/**
 * Created on 18.08.2017.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultProductFacadeTest {

  public static final int PRODUCT_ID = 1;
  public static final String PRODUCT_NAME = "Prius";
  public static final int QUANTITY_PRODUCT = 2;

  public static final double STOCK_PRICE = 12.0;
  public static final String CURRENCY = "EUR";
  public static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultProductFacade sut;

  private Map<ItemDTO, PriceDTO> products;

  @Mock
  private ProductService productService;

  ItemDTO itemDTO;
  PriceDTO priceDTO;

  @Before
  public void setUp() throws Exception {
    itemDTO = new DefaultItemDTO();
    priceDTO = new StockPriceDTO();

  }

  @Test
  public void shouldProductsMapBeNotNullAndNotEmptyIfProductExists() {
    //given

    //when

    //then

  }
}