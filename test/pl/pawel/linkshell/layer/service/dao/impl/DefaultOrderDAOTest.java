package pl.pawel.linkshell.layer.service.dao.impl;

import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.Order;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;

/**
 * Created on 18.08.2017.
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultOrderDAOTest {

  private static final int PRODUCT_ID = 1;
  private static final String PRODUCT_NAME = "Prius";
  private static final int QUANTITY_PRODUCT = 2;

  private static final double STOCK_PRICE = 12.0;
  private static final String CURRENCY = "EUR";
  private static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultOrderDAO sut;

  private List<Order> orders;
  Order order;

  @Before
  public void setUp() {
    orders = new ArrayList<>();
    order = createDummyOrder();
  }

  @Test
  public void shouldFindOrderByNameIfExistsInList() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotFindOrderByNameIfOrderNotExistsInList() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetOrderForAddedOrder() {
    //given

    //when

    //then

  }

  @Test
  public void shouldGetOrderByIdIfExistsInList() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotGetOrderByIdIfNotExistsInList() {
    //given

    //when

    //then

  }

  @Test
  public void shouldRemoveOrderIfIdIsValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldThrowExceptionForRemoveOrderIfIdIsNotValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldUpdateOrderByGivenIdAndNewOrder() {
    //given

    //when

    //then

  }

  @Test
  public void shouldThrowExceptionForUpdateOrderIdIsNotValid() {
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