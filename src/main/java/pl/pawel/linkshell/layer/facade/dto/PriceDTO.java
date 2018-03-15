package pl.pawel.linkshell.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
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
    return Double.compare(this.getUnit(), o.getUnit());
  }
}
