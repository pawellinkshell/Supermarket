package pl.koszela.jan.layer.ui.constans;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class PathConstans {

  public static final Map.Entry<String, String> SERVLET_NAME = new SimpleEntry<>(
      "servletPath", "Supermarket");

  //Paths
  public static final String PRODUCTS_PATH = "products";
  public static final String CART_PATH = "cart";

  //Actions on paths
  public static final Map.Entry<String, String> ADD_ACTION = new SimpleEntry<>(
      "addAction", "add");
  public static final Map.Entry<String, String> UPDATE_ACTION = new SimpleEntry<>(
      "updateAction", "update");
  public static final Map.Entry<String, String> REMOVE_ACTION = new SimpleEntry<>(
      "removeAction", "remove");

}
