package pl.pawel.linkshell.layer.ui.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.HashMap;
import java.util.Map;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import pl.pawel.linkshell.layer.facade.impl.DefaultCartFacade;
import pl.pawel.linkshell.layer.facade.impl.DefaultProductFacade;
import pl.pawel.linkshell.layer.ui.alerts.AlertManager;
import pl.pawel.linkshell.layer.ui.constans.AttributeConstans;
import pl.pawel.linkshell.layer.ui.constans.PathConstans;


/**
 * Created on 18.08.2017.
 *
 */
@RunWith(MockitoJUnitRunner.class)
public class BaseControllerTest {

  public static final String PRODUCT_NAME = "Prius";
  public static final int QUANTITY_PRODUCT = 2;

  public static final String INDEX_VIEW = "/";
  public static final String PRODUCTS_VIEW = "/products";
  public static final String CART_VIEW = "/cart";

  @InjectMocks
  private BaseController sut;

  private static Map<String, Object> modelAttributes;

  @Mock
  private DefaultProductFacade productFacade;

  @Mock
  private DefaultCartFacade cartFacade;

  @Mock
  private AlertManager alerts;

  private MockMvc mockMvc;

  @Before
  public void setUp() throws Exception {
    MockitoAnnotations.initMocks(this);
    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
    viewResolver.setPrefix("/WEB-INF/pages/");
    viewResolver.setSuffix(".jsp");
    mockMvc = MockMvcBuilders
        .standaloneSetup(sut)
        .setViewResolvers(viewResolver)
        .build();
  }

  @Test
  public void shouldReturnIndexView() throws Exception {
    mockMvc.perform(get(INDEX_VIEW))
        .andExpect(view().name("index"))
        .andReturn();
  }

  @Test
  public void shouldReturnProductsViewFieldsAreEmpty() {


  }

  private void setModelAttributes() {
    modelAttributes = new HashMap<>();

    modelAttributes.put(AttributeConstans.CART.getKey(),
        cartFacade.getCart());
    modelAttributes.put(AttributeConstans.PRODUCTS.getKey(),
        productFacade.getProducts());

    // Path Constants
    modelAttributes.put(PathConstans.SERVLET_NAME.getKey(),
        PathConstans.SERVLET_NAME.getValue());
    modelAttributes.put(PathConstans.PRODUCTS_PATH,
        PathConstans.PRODUCTS_PATH);
    modelAttributes.put(PathConstans.CART_PATH,
        PathConstans.CART_PATH);

    // Path action constants
    modelAttributes.put(PathConstans.ADD_ACTION.getKey(),
        PathConstans.ADD_ACTION.getValue());
    modelAttributes.put(PathConstans.REMOVE_ACTION.getKey(),
        PathConstans.REMOVE_ACTION.getValue());
  }
}