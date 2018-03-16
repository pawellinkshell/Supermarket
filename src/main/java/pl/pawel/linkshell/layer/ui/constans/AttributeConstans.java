package pl.pawel.linkshell.layer.ui.constans;

import java.util.AbstractMap.SimpleEntry;
import java.util.Map;

/**
 * Created on 12.08.2017.
 *
 */
public final class AttributeConstans {

  public static final Map.Entry<String, String> CART = new SimpleEntry<>(
      "cartItem", "");
  public static final Map.Entry<String, String> PRODUCTS = new SimpleEntry<>(
      "productItems", "");

  public static final String ALERT = "alerts";

  private AttributeConstans() {
    throw new IllegalStateException("Utility class");
  }

}
