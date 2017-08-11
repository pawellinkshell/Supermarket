package pl.koszela.jan.domain;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class Product {

  private int id;
  private String item;
  private double unitPrice;
  private String currency;
  private boolean multipricing;

  Product(int id, String item, double unitPrice, String currency, boolean multipricing) {
    this.id = id;
    this.item = item;
    this.unitPrice = unitPrice;
    this.currency = currency;
    this.multipricing = multipricing;
  }

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }

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

  public int getId() {
    return this.id;
  }

  public String getItem() {
    return this.item;
  }

  public double getUnitPrice() {
    return this.unitPrice;
  }

  public String getCurrency() {
    return this.currency;
  }

  public boolean isMultipricing() {
    return this.multipricing;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setItem(String item) {
    this.item = item;
  }

  public void setUnitPrice(double unitPrice) {
    this.unitPrice = unitPrice;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  public void setMultipricing(boolean multipricing) {
    this.multipricing = multipricing;
  }

  public static class ProductBuilder {

    private int id;
    private String item;
    private double unitPrice;
    private String currency;
    private boolean multipricing;

    ProductBuilder() {
    }

    public Product.ProductBuilder id(int id) {
      this.id = id;
      return this;
    }

    public Product.ProductBuilder item(String item) {
      this.item = item;
      return this;
    }

    public Product.ProductBuilder unitPrice(double unitPrice) {
      this.unitPrice = unitPrice;
      return this;
    }

    public Product.ProductBuilder currency(String currency) {
      this.currency = currency;
      return this;
    }

    public Product.ProductBuilder multipricing(boolean multipricing) {
      this.multipricing = multipricing;
      return this;
    }

    public Product build() {
      return new Product(id, item, unitPrice, currency, multipricing);
    }

    public String toString() {
      return "pl.koszela.jan.domain.Product.ProductBuilder(id=" + this.id + ", item=" + this.item
          + ", unitPrice=" + this.unitPrice + ", currency=" + this.currency + ", multipricing="
          + this.multipricing + ")";
    }
  }
}
