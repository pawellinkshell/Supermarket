package pl.koszela.jan.layer.model.domain;

/**
 * Created on 13.08.2017.
 *
 * @author Jan Koszela
 */
public interface Price {

  int getId();

  void setId(final int id);

  String getCurrency();

  void setCurrency(final String currency);

  double getUnit();

  void setUnit(final double price);
}
