package pl.pawel.linkshell.layer.service.impl;

import java.util.Map;
import java.util.TreeMap;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;
import pl.koszela.jan.layer.model.service.impl.DefaultModelService;

/**
 * Created on 18.08.2017.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultProductServiceTest {

  public static final int PRODUCT_ID = 1;
  public static final String PRODUCT_NAME = "Prius";
  public static final int QUANTITY_PRODUCT = 2;

  public static final double STOCK_PRICE = 12.0;
  public static final String CURRENCY = "EUR";
  public static final double TOTAL_PRICE = 24.0;


  @InjectMocks
  private DefaultProductService sut;

  @Mock
  private DefaultModelService modelService;

  private Map<Item, Price> products;
  Item item;
  StockPrice stockPrice;

  @Before
  public void setUp() throws Exception {
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