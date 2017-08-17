package pl.koszela.jan.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface ItemDTO  extends Comparable<ItemDTO>{

  int getId();

  void setId(final int id);

  String getItem();

  void setItem(final String item);

  @Override
  default int compareTo(ItemDTO o) {
    if (this.getId() == o.getId()) {
      return 0;
    } else if (this.getId() > o.getId()) {
      return 1;
    } else {
      return -1;
    }
  }
}
