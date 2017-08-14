package pl.koszela.jan.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import pl.koszela.jan.persistence.dto.impl.OrderDTO;
import pl.koszela.jan.domain.impl.Product;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DefaultOrderDTOServiceTest {

  @Mock
  private DefaultOrderService sut;

  private OrderDTO getDummyOrder() {
    return new OrderDTO(new Product(1, "Prius", false), 2);
  }

  @Test
  public void shouldReturnNullIfOrdersEmpty() {
    //given
    OrderDTO givenOrderDTO = getDummyOrder();

    //when
    when(sut.findOrderByName(givenOrderDTO.getProduct().getName())).thenReturn(null);

    //then
    assertThat(sut.findOrderByName(givenOrderDTO.getProduct().getName())).isNull();

  }

  @Test
  public void shouldReturnOrderByGivenProductName() {
    //given
    OrderDTO givenOrderDTO = getDummyOrder();

    //when
    sut.createOrder(givenOrderDTO);
    when(sut.findOrderByName(givenOrderDTO.getProduct().getName())).thenReturn(givenOrderDTO);

    //then
    assertThat(sut.findOrderByName(givenOrderDTO.getProduct().getName())).isEqualTo(givenOrderDTO);
  }

  @Test
  public void shouldCreateOrder() {
    //given
    OrderDTO givenOrderDTO = getDummyOrder();

    //when
    sut.createOrder(givenOrderDTO);
    when(sut.findOrderByName(givenOrderDTO.getProduct().getName())).thenReturn(givenOrderDTO);

    //then
    assertThat(sut.findOrderByName(givenOrderDTO.getProduct().getName()))
        .isNotNull()
        .isEqualTo(givenOrderDTO);
  }

  @Test
  public void shouldSameOrderBeUpdatedByQuantity() {
    //given
    OrderDTO givenOrderDTO = getDummyOrder();
    OrderDTO givenUpdatedOrderDTO = getDummyOrder();
    givenUpdatedOrderDTO.setQuantity(3);

    //when
    sut.createOrder(givenOrderDTO);
    sut.updateOrder(givenUpdatedOrderDTO);
    when(sut.findOrderByName(givenOrderDTO.getProduct().getName()))
        .thenReturn(givenUpdatedOrderDTO);


    //then
    assertThat(sut.findOrderByName(givenOrderDTO.getProduct().getName()))
        .isEqualTo(givenUpdatedOrderDTO);

  }
}
