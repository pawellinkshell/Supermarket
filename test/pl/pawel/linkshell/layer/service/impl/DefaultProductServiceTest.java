package pl.pawel.linkshell.layer.service.impl;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;
import pl.pawel.linkshell.layer.model.service.impl.DefaultModelService;

/**
 * Created on 18.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

  private static final int PRODUCT_ID = 1;
  private static final String PRODUCT_NAME = "Prius";
  private static final int QUANTITY_PRODUCT = 2;

  private static final double STOCK_PRICE = 12.0;
  private static final String CURRENCY = "EUR";
  private static final double TOTAL_PRICE = 24.0;


  @InjectMocks
  private DefaultProductService sut;

  @Mock
  private DefaultModelService modelService;

  private Map<Item, Price> products;
  private Item item;
  private StockPrice stockPrice;

  @Before
  public void setUp() {
    products = new TreeMap<>();
    item = new Item(PRODUCT_ID, PRODUCT_NAME);
    stockPrice = new StockPrice(PRODUCT_ID, STOCK_PRICE, CURRENCY);
  }

  @Test
  public void shouldProductsBeSizeOneIfOneProduct() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetItemIfExists() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotGetItemIfNotExists() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetPriceIfExists() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotGetPriceIfNotExists() {
    //given

    //when

    //then

  }

}