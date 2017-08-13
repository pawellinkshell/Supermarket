package pl.koszela.jan.persistence.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceDTO {

  int getId();

  void setId(final int id);

  double getPrice();

  void setPrice(final double price);

  String getCurrency();

  void setCurrency(final String currency);
}
