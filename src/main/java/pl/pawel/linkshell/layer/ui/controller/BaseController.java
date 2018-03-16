package pl.pawel.linkshell.layer.ui.controller;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.pawel.linkshell.layer.facade.CartFacade;
import pl.pawel.linkshell.layer.facade.ProductFacade;
import pl.pawel.linkshell.layer.ui.alerts.AlertManager;
import pl.pawel.linkshell.layer.ui.constans.AttributeConstans;
import pl.pawel.linkshell.layer.ui.constans.PathConstans;

/**
 * Created on 09.08.2017.
 */
@Controller
@EnableWebMvc
public class BaseController {

  private static final String VIEW_INDEX = "index";
  private static final Logger LOGGER = LoggerFactory.getLogger(BaseController.class);
  private static final String CURRENT_PATH = "currentPath";

  private Map<String, Object> modelAttributes;

  @Autowired
  private ProductFacade productFacade;

  @Autowired
  private CartFacade cartFacade;

  @Autowired
  private AlertManager alerts;

  @RequestMapping("/")
  public String welcomePage(ModelMap model) {
    LOGGER.debug("Page: /");

    return productsPage(model);
  }

  @RequestMapping("/" + PathConstans.PRODUCTS_PATH)
  public String productsPage(ModelMap model) {

    resolveAction(null, null, null);

    model.addAllAttributes(modelAttributes);
    model.addAttribute(CURRENT_PATH, PathConstans.PRODUCTS_PATH);

    LOGGER.debug("Page: /{}", PathConstans.PRODUCTS_PATH);
    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;
  }

  @RequestMapping(value = "/" + PathConstans.PRODUCTS_PATH + "/{name}", method = RequestMethod.GET)
  public String productsPageAddAction(@PathVariable String name, ModelMap model,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

    resolveAction(name, product, quantity);

    model.addAllAttributes(modelAttributes);
    model.addAttribute(CURRENT_PATH, PathConstans.PRODUCTS_PATH);

    LOGGER.debug("Page: /{}/{}", PathConstans.PRODUCTS_PATH, name);
    LOGGER.debug("Product = {}   Quantity = {}", product, quantity);
    return VIEW_INDEX;
  }

  @RequestMapping("/" + PathConstans.CART_PATH)
  public String cartPage(ModelMap model) {
    LOGGER.debug("Page: /{}", PathConstans.CART_PATH);
    return cartPageAction(null, model, null, null);
  }

  @RequestMapping(value = "/" + PathConstans.CART_PATH + "/{name}", method = RequestMethod.GET)
  public String cartPageAction(@PathVariable String name, ModelMap model,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

    resolveAction(name, product, quantity);

    model.addAllAttributes(modelAttributes);
    model.addAttribute(CURRENT_PATH, PathConstans.CART_PATH);

    LOGGER.debug("Page: /{}/{}", PathConstans.CART_PATH, name);
    LOGGER.debug("Product = {}   Quantity = {}", product, quantity);
    return VIEW_INDEX;
  }

  private void resolveAction(@PathVariable String name,
      @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

    initActions();

    if (product != null) {
      if (isRemoveAction(name)) {
        boolean isRemoved = cartFacade.removeOrderFromCart(product);
        setAlert(isRemoved, PathConstans.REMOVE_ACTION.getValue());

        LOGGER.info("Order name: '{}' was removed: {}", product, isRemoved);
      } else if (isAddAction(name)) {

        boolean isOrderAdded = cartFacade.addOrderToCart(product, quantity);
        if (isOrderAdded) {
          setAlert(isOrderAdded, PathConstans.ADD_ACTION.getValue());
          LOGGER.info("Order name: '{}' was added: {}", product, isOrderAdded);
        } else {
          boolean isOrderUpdated = cartFacade.updateOrderInCart(product, quantity);
          setAlert(isOrderUpdated, PathConstans.UPDATE_ACTION.getValue());
          LOGGER.info("Order name: '{}' was updated: {}", product, isOrderUpdated);
        }
      }
      modelAttributes.put(AttributeConstans.ALERT, alerts);
    }
  }

  private void setAlert(boolean condition, @PathVariable String name) {
    // REMOVE ACTION
    if (isRemoveAction(name)) {
      if (condition) {
        alerts.setAlert(AlertManager.SUCCESS, "Order was REMOVED from cart");
        return;
      } else {
        alerts.setAlert(AlertManager.ERROR, "Order cannot be REMOVED");
        return;
      }
    }

    // ADD ACTION
    if (condition && isAddAction(name)) {
      alerts.setAlert(AlertManager.SUCCESS, "Order was ADD to cart");
      return;
    }

    //UPDATE ACTION
    if (isUpdateAction(name)) {
      if (condition) {
        alerts.setAlert(AlertManager.WARNING, "Order was UPDATED in cart");
      } else {
        alerts.setAlert(AlertManager.ERROR, "Order cannot be UPDATED in cart");
      }
    }
  }

  private void initActions() {
    alerts.cleanAlert();
    setModelAttributes();
  }

  private boolean isAddAction(@PathVariable String name) {
    return PathConstans.ADD_ACTION.getValue().equals(name);
  }

  private boolean isRemoveAction(@PathVariable String name) {
    return PathConstans.REMOVE_ACTION.getValue().equals(name);
  }

  private boolean isUpdateAction(@PathVariable String name) {
    return PathConstans.UPDATE_ACTION.getValue().equals(name);
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