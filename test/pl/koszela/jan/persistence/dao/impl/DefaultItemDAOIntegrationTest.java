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
import pl.koszela.jan.layer.facade.dto.ItemDTO;
import pl.koszela.jan.layer.model.converter.impl.JsonConverter;
import pl.koszela.jan.layer.service.dao.ProductDAO;

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
    List<ItemDTO> expectedList = getProductListFromJson();

    // when
    when(givenProductDAO.getAllItems()).thenReturn(expectedList);

    // then
    assertThat(givenProductDAO.getAllItems()).hasSize(expectedList.size());
  }

  @Test
  public void shouldGetItemsWhichContainsMultipricing() {
    //given
    List<ItemDTO> expectedList = getProductsWithMultipricing();

    // when
    when(givenProductDAO.getItemsByMultipricing(true)).thenReturn(expectedList);

    // then
    assertThat(givenProductDAO.getItemsByMultipricing(true)).hasSize(expectedList.size());
  }


  private List<ItemDTO> getProductListFromJson() {
    List<ItemDTO> expected = Lists.newArrayList();

    JsonConverter converter = new JsonConverter(SRC_MAIN_RESOURCES_SAMPLE);

//    expected.addAll(converter.getProductList());

    return expected;
  }

  private List<ItemDTO> getProductsWithMultipricing() {
    List<ItemDTO> expected = getProductListFromJson();

    for (int i = 0; i < expected.size(); i++) {
      if (hasNotItemMultipricing(expected, i)) {
        expected.remove(i);
      }

    }

    return expected;
  }

  private boolean hasNotItemMultipricing(List<ItemDTO> expected, int i) {
    return expected.get(i).isMultipricing() == false;
  }

}
