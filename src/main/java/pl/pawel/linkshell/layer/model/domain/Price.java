package pl.pawel.linkshell.layer.model.domain;

/**
 * Created on 13.08.2017.
 *
 */
public interface Price extends Comparable<Price>{

  int getId();

  void setId(final int id);

  String getCurrency();

  void setCurrency(final String currency);

  double getUnit();

  void setUnit(final double price);

  @Override
  default int compareTo(Price o) {
    if (this.getUnit() == o.getUnit()) {
      return 0;
    } else if (this.getUnit() > o.getUnit()) {
      return 1;
    } else {
      return -1;
    }
  }
}
