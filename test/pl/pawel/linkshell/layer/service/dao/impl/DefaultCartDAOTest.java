package pl.pawel.linkshell.layer.service.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.model.domain.Price;
import pl.pawel.linkshell.layer.model.domain.impl.Cart;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;

/**
 * Created on 18.08.2017.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCartDAOTest {

  private static final int PRODUCT_ID = 1;
  private static final String PRODUCT_NAME = "Prius";
  private static final int QUANTITY_PRODUCT = 2;

  private static final double STOCK_PRICE = 12.0;
  private static final String CURRENCY = "EUR";
  private static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultCartDAO sut;

  private Cart cart;
  private Order order;
  private Price price;

  @Before
  public void setUp() {
    cart = new Cart();
    order = createDummyOrder();
    price = new StockPrice(PRODUCT_ID, TOTAL_PRICE, CURRENCY);

  }

  @Test
  public void shouldGetOrderFromCartIfNotNull() {
    //given

    //when

    //then

  }

  @Test
  public void shouldAddOrderToCartByGivenOrderAndValidQuantity() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotAddOrderToCartByGivenOrderWhenQuantityIsNotValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldUpdateOrderInCartByGivenOrderAndValidQuantity() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotUpdateOrderInCartByGivenOrderWhenQuantityIsNotValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldRemoveOrderFromCartIfIdOfItemIsSameFromGivenItemFromOrder() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotRemoveOrderFromCartIfItemNotExistsInCart() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetTotalPriceFromCart() {
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