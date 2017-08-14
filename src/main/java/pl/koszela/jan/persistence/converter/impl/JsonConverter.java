package pl.koszela.jan.persistence.converter.impl;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import pl.koszela.jan.domain.impl.NormalPrice;
import pl.koszela.jan.domain.impl.Product;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.converter.Converter;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class JsonConverter implements Converter{

  public static final Gson GSON = new Gson();
  private static final String PRODUCT_FILE = "sample/MOCK_DATA_Products.json";
  private static final String NORMAL_PRICES_FILE = "sample/MOCK_DATA_Prices.json";
  private static final String SPECIAL_PRICES_FILE = "sample/MOCK_DATA_Special_Prices.json";
  public static String resourcesSamplePath;

  public JsonConverter() {
    this.resourcesSamplePath = getClass().getClassLoader().getResource("/").getPath();
  }

  public JsonConverter(String resourcePath) {
    this.resourcesSamplePath = resourcePath;
  }

  public Product[] convertProducts() {
    Product[] products = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + this.PRODUCT_FILE)) {

      // Convert JSON to Java Object
      products = GSON.fromJson(reader, Product[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return products;
  }

  public SpecialPrice[] convertSpecialPrices() {
    SpecialPrice[] specialPrices = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + this.SPECIAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      specialPrices = GSON.fromJson(reader, SpecialPrice[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return specialPrices;
  }

  public NormalPrice[] convertNormalPrices() {
    NormalPrice[] normalPrices = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + this.NORMAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      normalPrices = GSON.fromJson(reader, NormalPrice[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }

    return normalPrices;
  }

}
