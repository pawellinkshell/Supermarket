package pl.koszela.jan.domain;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class SpecialPrice {

  private int id;
  private int amount;
  private double price;

  SpecialPrice(int id, int amount, double price) {
    this.id = id;
    this.amount = amount;
    this.price = price;
  }

  public static SpecialPriceBuilder builder() {
    return new SpecialPriceBuilder();
  }

  public int getId() {
    return this.id;
  }

  public int getAmount() {
    return this.amount;
  }

  public double getPrice() {
    return this.price;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setAmount(int amount) {
    this.amount = amount;
  }

  public void setPrice(double price) {
    this.price = price;
  }

  public static class SpecialPriceBuilder {

    private int id;
    private int amount;
    private double price;

    SpecialPriceBuilder() {
    }

    public SpecialPrice.SpecialPriceBuilder id(int id) {
      this.id = id;
      return this;
    }

    public SpecialPrice.SpecialPriceBuilder amount(int amount) {
      this.amount = amount;
      return this;
    }

    public SpecialPrice.SpecialPriceBuilder price(double price) {
      this.price = price;
      return this;
    }

    public SpecialPrice build() {
      return new SpecialPrice(id, amount, price);
    }

    public String toString() {
      return "pl.koszela.jan.domain.SpecialPrice.SpecialPriceBuilder(id=" + this.id + ", amount="
          + this.amount + ", price=" + this.price + ")";
    }
  }
}
