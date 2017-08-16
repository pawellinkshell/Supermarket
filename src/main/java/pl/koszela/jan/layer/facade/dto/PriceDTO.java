package pl.koszela.jan.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceDTO extends Comparable<PriceDTO>{

  int getId();

  void setId(final int id);

  double getUnit();

  void setUnit(final double price);

  String getCurrency();

  void setCurrency(final String currency);

  @Override
  default int compareTo(PriceDTO o) {
    if (this.getUnit() == o.getUnit()) {
      return 0;
    } else if (this.getUnit() > o.getUnit()) {
      return 1;
    } else {
      return -1;
    }
  }
}
