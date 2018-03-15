package pl.pawel.linkshell.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
 */
public interface ItemDTO  extends Comparable<ItemDTO>{

  int getId();

  void setId(final int id);

  String getItem();

  void setItem(final String item);

  @Override
  default int compareTo(ItemDTO o) {
    return Integer.compare(this.getId(), o.getId());
  }
}
