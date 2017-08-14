package pl.koszela.jan.persistence.dao.impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import java.util.List;
import org.assertj.core.util.Lists;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.ActiveProfiles;
import pl.koszela.jan.layer.service.dao.ProductDAO;
import pl.koszela.jan.layer.facade.dto.ProductDTO;
import pl.koszela.jan.layer.facade.dto.impl.DefaultProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DefaultItemDAOTest {

  public static final int ID = 1;
  public static final String ITEM = "Civic";
  public static final int UNIT_PRICE = 72;
  public static final String CURRENCY = "EUR";
  public static final boolean MULTIPRICING = true;

  public static final int SIZE = 15;
  public static final String PLN_CURRENCY = "PLN";

  @Mock
  private ProductDAO givenProductDAO;

  @Before
  public void setUp() {
  }

  @Test
  public void shouldGetAllItems() {
    //given
    List<ProductDTO> expectedList = getProducts();

    // when
    when(givenProductDAO.getAllItems()).thenReturn(expectedList);

    // then
    assertThat(givenProductDAO.getAllItems()).hasSize(expectedList.size());
  }

  @Test
  public void shouldGetItemsWhichContainsMultipricing() {
    //given
    List<ProductDTO> expectedList = getProductsWithMultipricing();

    // when
    when(givenProductDAO.getItemsByMultipricing(true)).thenReturn(expectedList);

    // then
    assertThat(givenProductDAO.getItemsByMultipricing(true)).hasSize(expectedList.size());
  }

  private List<ProductDTO> getProductsWithMultipricing() {
    List<ProductDTO> expected = Lists.newArrayList();

    for (int i = 0; i < SIZE; i++) {
      expected.add(
          createProductDTO(i, ITEM + "_" + i, UNIT_PRICE, CURRENCY, (i % 2 == 0) ? true : false));
    }

    for (int i = 0; i < expected.size(); i++) {
      if (hasNotItemMultipricing(expected, i)) {
        expected.remove(i);
      }

    }

    return expected;
  }

  private boolean hasNotItemMultipricing(List<ProductDTO> expected, int i) {
    return expected.get(i).isMultipricing() == false;
  }

  private List<ProductDTO> getProducts() {
    List<ProductDTO> expected = Lists.newArrayList();

    for (int i = 0; i < SIZE; i++) {
      expected.add(createProductDTO(i, ITEM + "_" + i, UNIT_PRICE, CURRENCY, MULTIPRICING));
    }

    return expected;
  }

  private ProductDTO createProductDTO(int id, String item, int unitPrice, String currency,
      boolean multipricing) {
    DefaultProductDTO productDTO = new DefaultProductDTO();
    productDTO.setId(id);
    productDTO.setItem(item);
    productDTO.setMultipricing(multipricing);

    return productDTO;
  }
}
