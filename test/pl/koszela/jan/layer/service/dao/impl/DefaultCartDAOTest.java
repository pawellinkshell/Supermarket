package pl.koszela.jan.layer.service.dao.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import pl.koszela.jan.layer.model.domain.Price;
import pl.koszela.jan.layer.model.domain.impl.Cart;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;

/**
 * Created on 18.08.2017.
 *
 * @author Jan Koszela
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultCartDAOTest {

  public static final int PRODUCT_ID = 1;
  public static final String PRODUCT_NAME = "Prius";
  public static final int QUANTITY_PRODUCT = 2;

  public static final double STOCK_PRICE = 12.0;
  public static final String CURRENCY = "EUR";
  public static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultCartDAO sut;

  Cart cart;
  Order order;
  Price price;

  @Before
  public void setUp() throws Exception {
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