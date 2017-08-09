package pl.koszela.jan.persistence.dto;

import java.util.Currency;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface ProductDTO {

  int getId();

  void setId(final int id);

  String getItem();

  void setItem(final String item);

  double getUnitPrice();

  void setUnitPrice(final double unitPrice);

  String getCurrency();

  void setCurrency(final String currency);

  boolean isMultipricing();

  void setMultipricing(final boolean isMultipricing);
}
