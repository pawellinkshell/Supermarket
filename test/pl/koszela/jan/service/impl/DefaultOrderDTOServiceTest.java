package pl.koszela.jan.service.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import pl.koszela.jan.layer.service.impl.DefaultOrderService;
import pl.koszela.jan.layer.facade.dto.impl.DefaultOrderDTO;
import pl.koszela.jan.layer.model.domain.impl.Item;

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

  private DefaultOrderDTO getDummyOrder() {
    return new DefaultOrderDTO(new Item(1, "Prius", false), 2);
  }

  @Test
  public void shouldReturnNullIfOrdersEmpty() {
    //given
    DefaultOrderDTO givenOrderDTO = getDummyOrder();

    //when
    when(sut.getOrderByName(givenOrderDTO.getItem().getName())).thenReturn(null);

    //then
    assertThat(sut.getOrderByName(givenOrderDTO.getItem().getName())).isNull();

  }

  @Test
  public void shouldReturnOrderByGivenProductName() {
    //given
    DefaultOrderDTO givenOrderDTO = getDummyOrder();

    //when
    sut.createOrder(givenOrderDTO);
    when(sut.getOrderByName(givenOrderDTO.getItem().getName())).thenReturn(givenOrderDTO);

    //then
    assertThat(sut.getOrderByName(givenOrderDTO.getItem().getName())).isEqualTo(givenOrderDTO);
  }

  @Test
  public void shouldCreateOrder() {
    //given
    DefaultOrderDTO givenOrderDTO = getDummyOrder();

    //when
    sut.createOrder(givenOrderDTO);
    when(sut.getOrderByName(givenOrderDTO.getItem().getName())).thenReturn(givenOrderDTO);

    //then
    assertThat(sut.getOrderByName(givenOrderDTO.getItem().getName()))
        .isNotNull()
        .isEqualTo(givenOrderDTO);
  }

  @Test
  public void shouldSameOrderBeUpdatedByQuantity() {
    //given
    DefaultOrderDTO givenOrderDTO = getDummyOrder();
    DefaultOrderDTO givenUpdatedOrderDTO = getDummyOrder();
    givenUpdatedOrderDTO.setQuantity(3);

    //when
    sut.createOrder(givenOrderDTO);
    sut.updateOrder(givenUpdatedOrderDTO);
    when(sut.getOrderByName(givenOrderDTO.getItem().getName()))
        .thenReturn(givenUpdatedOrderDTO);


    //then
    assertThat(sut.getOrderByName(givenOrderDTO.getItem().getName()))
        .isEqualTo(givenUpdatedOrderDTO);

  }
}
