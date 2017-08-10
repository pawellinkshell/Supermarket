package pl.koszela.jan.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
@Builder
@Getter
@Setter
public class Product {

  private int id;
  private String item;
  private double unitPrice;
  private String currency;
  private boolean multipricing;

  @Override
  public String toString() {
    return "Product{" +
        "id=" + id +
        ", item='" + item + '\'' +
        ", unitPrice=" + unitPrice +
        ", currency='" + currency + '\'' +
        ", multipricing=" + multipricing +
        '}';
  }
}
