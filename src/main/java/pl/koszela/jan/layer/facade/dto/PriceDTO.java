package pl.koszela.jan.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceDTO {

  int getId();

  void setId(final int id);

  double getUnit();

  void setUnit(final double price);

  String getCurrency();

  void setCurrency(final String currency);
}
