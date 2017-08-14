package pl.koszela.jan.persistence.dto;

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

  boolean isMultipricing();

  void setMultipricing(final boolean isMultipricing);
}
