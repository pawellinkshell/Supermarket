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
import pl.koszela.jan.layer.model.converter.impl.JsonConverter;
import pl.koszela.jan.layer.service.dao.ProductDAO;
import pl.koszela.jan.layer.facade.dto.ProductDTO;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
@ActiveProfiles("test")
@RunWith(MockitoJUnitRunner.class)
public class DefaultItemDAOIntegrationTest {

  public static final String SRC_MAIN_RESOURCES_SAMPLE = "src\\main\\resources\\sample\\";
  @Mock
  private ProductDAO givenProductDAO;

  @Before
  public void setUp() {
  }

  @Test
  public void shouldGetAllItems() {
    //given
    List<ProductDTO> expectedList = getProductListFromJson();

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


  private List<ProductDTO> getProductListFromJson() {
    List<ProductDTO> expected = Lists.newArrayList();

    JsonConverter converter = new JsonConverter(SRC_MAIN_RESOURCES_SAMPLE);

//    expected.addAll(converter.getProductList());

    return expected;
  }

  private List<ProductDTO> getProductsWithMultipricing() {
    List<ProductDTO> expected = getProductListFromJson();

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

}
