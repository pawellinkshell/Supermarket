package pl.pawel.linkshell.layer.model.service.impl;

import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.facade.dto.ItemDTO;
import pl.pawel.linkshell.layer.facade.dto.PriceDTO;
import pl.pawel.linkshell.layer.facade.impl.DefaultProductFacade;
import pl.pawel.linkshell.layer.model.converter.Converter;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.SpecialPrice;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;

/**
 * Created on 18.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultModelServiceTest {

  private static final int PRODUCT_ID = 1;
  private static final String PRODUCT_NAME = "Prius";
  private static final int QUANTITY_PRODUCT = 2;

  private static final double STOCK_PRICE = 12.0;
  private static final String CURRENCY = "EUR";
  private static final double TOTAL_PRICE = 24.0;
  private static final int SPECIALPRICE_AMOUNT = 2;

  @InjectMocks
  private DefaultProductFacade sut;

  private Map<ItemDTO, PriceDTO> products;

  @Mock
  private Converter converter;

  private Item item;
  private Price stockPrice;
  private SpecialPrice specialPrice;

  @Before
  public void setUp() {
    item = new Item(PRODUCT_ID, PRODUCT_NAME);
    stockPrice = new StockPrice(PRODUCT_ID, STOCK_PRICE, CURRENCY);
    specialPrice = new SpecialPrice(PRODUCT_ID, SPECIALPRICE_AMOUNT, STOCK_PRICE, CURRENCY);

  }

  @Test
  public void shouldGetItemFromConverterIfFileExists() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotGetItemFromConverterIfFileNotExists() {
    //given

    //when

    //then

  }


  @Test
  public void shouldGetPriceFromConverterIfFileExists() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotGetPriceFromConverterIfFileNotExists() {
    //given

    //when

    //then

  }

}