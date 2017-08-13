package pl.koszela.jan.domain.impl;

/**
 * Created on 11.08.2017.
 *
 * @author Jan Koszela
 */
public class Product {

  private int id;
  private String name;
  private boolean multipricing;

  Product(int id, String name, boolean multipricing) {
    this.id = id;
    this.name = name;
    this.multipricing = multipricing;
  }

  public static ProductBuilder builder() {
    return new ProductBuilder();
  }

  public int getId() {
    return this.id;
  }

  public String getName() {
    return this.name;
  }

  public boolean isMultipricing() {
    return multipricing;
  }

  public void setId(int id) {
    this.id = id;
  }

  public void setName(String name) {
    this.name = name;
  }

  public void setMultipricing(boolean multipricing) {
    this.multipricing = multipricing;
  }

  public static class ProductBuilder {

    private int id;
    private String name;
    private boolean multipricing;

    ProductBuilder() {
    }

    public Product.ProductBuilder id(int id) {
      this.id = id;
      return this;
    }

    public Product.ProductBuilder name(String name) {
      this.name = name;
      return this;
    }

    public Product.ProductBuilder multipricing(boolean multipricing) {
      this.multipricing = multipricing;
      return this;
    }

    public Product build() {
      return new Product(id, name, multipricing);
    }

    public String toString() {
      return "pl.koszela.jan.domain.impl.Product.ProductBuilder(id=" + this.id + ", name="
          + this.name
          + ", multipricing=" + this.multipricing + ")";
    }
  }
}
