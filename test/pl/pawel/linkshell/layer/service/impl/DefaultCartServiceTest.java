package pl.pawel.linkshell.layer.service.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;
import pl.pawel.linkshell.layer.service.dao.CartDAO;

/**
 * Created on 18.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCartServiceTest {

  private static final int PRODUCT_ID = 1;
  private static final String PRODUCT_NAME = "Prius";
  private static final int QUANTITY_PRODUCT = 2;

  private static final double STOCK_PRICE = 12.0;
  private static final String CURRENCY = "EUR";
  private static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultCartService sut;

  @Mock
  private CartDAO cartDAO;

  private Item item;
  private StockPrice stockPrice;

  @Before
  public void setUp() {
    item = new Item(PRODUCT_ID, PRODUCT_NAME);
    stockPrice = new StockPrice(PRODUCT_ID, STOCK_PRICE, CURRENCY);
  }

  @Test
  public void shouldGetEmptyCartIfNoOrders() {
    //given

    //when

    //then

  }

  @Test
  public void shouldSizeOfCartBeOneIfOneOrder() {
    //given

    //when

    //then

  }

  @Test
  public void shouldOrderBeAddToCartIfValidQuantity() {
    //given

    //when

    //then

  }

  @Test
  public void shouldOrderNotBeAddToCartIfQuantityIsNotValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotRemoveOrderFromCartIfOrderIsNull() {
    //given

    //when

    //then

  }

  @Test
  public void shouldRemoveOrderFromCartIfItemIDIsSameAsCallingOrder() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotRemovedOrderFromCartIfOrderNotFound() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetTotalPriceOfCartIfOrderExists() {
    //given

    //when

    //then

  }

  private Order createDummyOrder() {
    Order dummyOrder = new Order();
    dummyOrder.setItem(new Item(PRODUCT_ID, PRODUCT_NAME));
    dummyOrder.setQuantity(QUANTITY_PRODUCT);
    dummyOrder.setStockPrice(new StockPrice(PRODUCT_ID, STOCK_PRICE, CURRENCY));
    dummyOrder.setSpecialOffer(false);
    dummyOrder.setTotalPrice(new StockPrice(PRODUCT_ID, TOTAL_PRICE, CURRENCY));

    return dummyOrder;
  }
}