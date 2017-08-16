package pl.koszela.jan.layer.ui.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.koszela.jan.layer.facade.CartFacade;
import pl.koszela.jan.layer.facade.ProductFacade;
import pl.koszela.jan.layer.ui.constans.AttributeConstans;
import pl.koszela.jan.layer.ui.constans.PathConstans;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
@Controller
@EnableWebMvc
public class BaseController {

  private static int counter = 0;
  private static final String VIEW_INDEX = "index";
  private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

  private static Map<String, Object> modelAttributes;

  @Autowired
  private ProductFacade productFacade;

  @Autowired
  private CartFacade cartFacade;

  @RequestMapping("/")
  public String welcomePage(ModelMap model) {
    setModelAttributes();

    model.addAllAttributes(modelAttributes);
    model.addAttribute("currentPath", PathConstans.PRODUCTS_PATH);

    model.addAttribute("message", "Welcome");
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcome] counter : {}", counter);

    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;
  }

  @RequestMapping("/" + PathConstans.PRODUCTS_PATH)
  public String productsPage(ModelMap model) {

    model.addAllAttributes(modelAttributes);

    model.addAttribute("currentPath", PathConstans.PRODUCTS_PATH);
    model.addAttribute("message", "Welcome ");
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);

    return VIEW_INDEX;
  }

  @RequestMapping(value = "/" + PathConstans.PRODUCTS_PATH + "/{name}", method = RequestMethod.GET)
  public String productsPageAddAction(@PathVariable String name, ModelMap model,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

    resolveAction(name, product, quantity);

    model.addAllAttributes(modelAttributes);

    model.addAttribute("currentPath",
        PathConstans.PRODUCTS_PATH);
    model.addAttribute("message",
        "Welcome ");
    model.addAttribute("counter",
        ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);

    return VIEW_INDEX;

  }

  private void resolveAction(@PathVariable String name,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {
    if (removeAction(name)) {
      if (product != null) {
        cartFacade.removeOrderFromCart(product);
      }
    } else if (addAction(name)) {
      if (product != null) {
        cartFacade.addOrderToCart(product, quantity);
      }
    }
  }

  private boolean addAction(@PathVariable String name) {
    return name.equals(PathConstans.ADD_ACTION.getValue());
  }

  private boolean removeAction(@PathVariable String name) {
    return name.equals(PathConstans.REMOVE_ACTION.getValue());
  }

  @RequestMapping("/" + PathConstans.CART_PATH)
  public String cartPage(ModelMap model) {
    model.addAllAttributes(modelAttributes);

    model.addAttribute("currentPath", PathConstans.CART_PATH);
    model.addAttribute("message", "Welcome ");
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);

    return VIEW_INDEX;
  }

  @RequestMapping(value = "/" + PathConstans.CART_PATH + "/{name}", method = RequestMethod.GET)
  public String cartPageAction(@PathVariable String name, ModelMap model,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

    resolveAction(name, product, quantity);

    model.addAllAttributes(modelAttributes);

    model.addAttribute("currentPath", PathConstans.CART_PATH);
    model.addAttribute("message", "Welcome ");
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);

    return VIEW_INDEX;

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