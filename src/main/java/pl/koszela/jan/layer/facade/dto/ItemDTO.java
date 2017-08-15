package pl.koszela.jan.layer.facade.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface ItemDTO {

  int getId();

  void setId(final int id);

  String getItem();

  void setItem(final String item);

  boolean isMultipricing();

  void setMultipricing(final boolean isMultipricing);
}
