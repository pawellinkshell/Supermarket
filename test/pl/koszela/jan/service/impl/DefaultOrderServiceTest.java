package pl.koszela.jan.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import pl.koszela.jan.domain.Order;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DefaultOrderServiceTest {

  @Mock
  private DefaultOrderService sut;

  private Order getDummyOrder() {
    return new Order("Prius", 2);
  }

  @Test
  public void shouldReturnNullIfOrdersEmpty() {
    //given
    Order givenOrder = getDummyOrder();

    //when
    when(sut.findOrderByName(givenOrder.getProductName())).thenReturn(null);

    //then
    assertThat(sut.findOrderByName(givenOrder.getProductName())).isNull();

  }

  @Test
  public void shouldReturnOrderByGivenProductName() {
    //given
    Order givenOrder = getDummyOrder();

    //when
    sut.createOrder(givenOrder);
    when(sut.findOrderByName(givenOrder.getProductName())).thenReturn(givenOrder);

    //then
    assertThat(sut.findOrderByName(givenOrder.getProductName())).isEqualTo(givenOrder);
  }

  @Test
  public void shouldCreateOrder() {
    //given
    Order givenOrder = getDummyOrder();

    //when
    sut.createOrder(givenOrder);
    when(sut.findOrderByName(givenOrder.getProductName())).thenReturn(givenOrder);

    //then
    assertThat(sut.findOrderByName(givenOrder.getProductName()))
        .isNotNull()
        .isEqualTo(givenOrder);
  }

  @Test
  public void shouldSameOrderBeUpdatedByQuantity() {
    //given
    Order givenOrder = getDummyOrder();
    Order givenUpdatedOrder = getDummyOrder();
    givenUpdatedOrder.setQuantity(3);

    //when
    sut.createOrder(givenOrder);
    sut.updateOrder(givenUpdatedOrder);
    when(sut.findOrderByName(givenOrder.getProductName()))
        .thenReturn(givenUpdatedOrder);


    //then
    assertThat(sut.findOrderByName(givenOrder.getProductName()))
        .isEqualTo(givenUpdatedOrder);

  }
}
