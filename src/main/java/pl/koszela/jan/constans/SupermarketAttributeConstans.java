package pl.koszela.jan.constans;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

/**
 * Created on 12.08.2017.
 *
 * @author Jan Koszela
 */
public class SupermarketAttributeConstans {

  public static final Map.Entry<String, String> SERVLET_NAME = new SimpleEntry<>(
      "servletPath", "Supermarket");
  public static final Map.Entry<String, String> ADD_DOMAIN_NAME = new SimpleEntry<>(
      "addDomain", "add");
  public static final Map.Entry<String, String> PRODUCTS_LIST = new SimpleEntry<>(
      "productsDTO", "");
  public static final Map.Entry<String, String> CART = new SimpleEntry<>(
      "carts", "");

}
