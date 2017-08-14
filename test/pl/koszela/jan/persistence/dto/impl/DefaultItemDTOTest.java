package pl.koszela.jan.persistence.dto.impl;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import pl.koszela.jan.layer.facade.dto.ProductDTO;
import pl.koszela.jan.layer.facade.dto.impl.DefaultProductDTO;

import static org.assertj.core.api.Assertions.*;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */

@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DefaultItemDTOTest {
  public static final int ID = 1;
  public static final String ITEM = "Civic";
  public static final int UNIT_PRICE = 72;
  public static final String CURRENCY = "EUR";
  public static final boolean MULTIPRICING = true;

  private ProductDTO givenProductDTO;

  @Before
  public void setUp(){
    givenProductDTO = createProductDTO(ID, ITEM, UNIT_PRICE, CURRENCY, MULTIPRICING);
  }

  private ProductDTO createProductDTO(int id, String item, int unitPrice, String currency,
      boolean multipricing) {
    DefaultProductDTO productDTO = new DefaultProductDTO();
    productDTO.setId(id);
    productDTO.setItem(item);
    productDTO.setMultipricing(multipricing);

    return productDTO;
  }

  @Test
  public void shouldGetId() {
    assertThat(givenProductDTO.getId()).isEqualTo(ID);
  }

  @Test
  public void shouldGetItem() {
    assertThat(givenProductDTO.getItem()).isEqualTo(ITEM);
  }

  @Test
  public void shouldGetMultipricing() {
    assertThat(givenProductDTO.isMultipricing()).isEqualTo(MULTIPRICING);
  }

  @Test
  public void shouldBeNotNull() {
    assertThat(givenProductDTO).isNotNull();
  }
}
