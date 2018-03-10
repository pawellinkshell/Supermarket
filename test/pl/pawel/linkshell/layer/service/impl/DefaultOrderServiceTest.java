package pl.pawel.linkshell.layer.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import pl.koszela.jan.layer.model.domain.impl.Item;
import pl.koszela.jan.layer.model.domain.impl.Order;
import pl.koszela.jan.layer.model.domain.impl.StockPrice;
import pl.koszela.jan.layer.model.service.impl.DefaultModelService;
import pl.koszela.jan.layer.service.dao.OrderDAO;

/**
 * Created on 18.08.2017.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class DefaultOrderServiceTest {

  public static final int PRODUCT_ID = 1;
  public static final String PRODUCT_NAME = "Prius";
  public static final int QUANTITY_PRODUCT = 2;

  public static final double STOCK_PRICE = 12.0;
  public static final String CURRENCY = "EUR";
  public static final double TOTAL_PRICE = 24.0;

  @InjectMocks
  private DefaultOrderService sut;

  @Mock
  private DefaultModelService modelService;

  @Mock
  private OrderDAO orderDAO;

  Item item;
  StockPrice stockPrice;

  @Before
  public void setUp() throws Exception {
    item = new Item(PRODUCT_ID, PRODUCT_NAME);
    stockPrice = new StockPrice(PRODUCT_ID, STOCK_PRICE, CURRENCY);
  }


  @Test
  public void shouldGetOrderIfExists() {
    //given
    Order expectedOrder = createDummyOrder();

    //when
    when(orderDAO.findOrderByName(PRODUCT_NAME)).thenReturn(expectedOrder);

    //then
    assertThat(expectedOrder)
        .isEqualTo(sut.getOrderByName(PRODUCT_NAME));
  }

  @Test
  public void shouldGetNullIfOrderNotExists() {
    //given
    Order actualOrder = null;

    //when
    when(orderDAO.findOrderByName(PRODUCT_NAME)).thenReturn(null);

    //then
    assertThat(actualOrder)
        .isEqualTo(sut.getOrderByName(PRODUCT_NAME));
  }

  @Test
  public void shouldCreateOrderIfValidQuantity() {
    //given

    //when

    //then
  }

  @Test
  public void shouldNotCreateOrderIfValidQuantity() {
    //given

    //when

    //then

  }

  @Test
  public void shouldOrderBeUpdatedIfQuantityIsValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldOrderNotBeUpdatedIfQuantityIsNotValid() {
    //given

    //when

    //then

  }

  @Test
  public void shouldRemoveOrderIfValidQuantity() {
    //given

    //when

    //then

  }

  @Test
  public void shouldNotRemoveOrderIfQuantityNotValid() {
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