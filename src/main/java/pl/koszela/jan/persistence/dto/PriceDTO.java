package pl.koszela.jan.persistence.dto;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
public interface PriceDTO {

  int getId();

  void setId(final int id);

  int getAmount();

  void setAmount(final int amount);

  double getPrice();

  void setPrice(final double price);
}
