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
public class SpecialPrice {

  private int id;
  private int amount;
  private double price;
}
