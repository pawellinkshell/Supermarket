package pl.koszela.jan.persistence.dto;

import javax.annotation.Resource;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.assertj.core.api.Assertions.*;
/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class JsonProductDTOTest {

  @Resource
  private ProductDTO productDTO;

  @Before
  public void setUp() throws Exception {
    ApplicationContext context = new ClassPathXmlApplicationContext("mvc-dispatcher-servlet.xml");
    ProductDTO dto = (ProductDTO) context.getBean("productDTO");
    dto.setId(1);
  }

  @Test
  public void shouldGetIdFromJSON() {
    assertThat(productDTO.getId()).isEqualTo(1);
  }

  @Test
  public void testGetCompetition() {

  }
}
