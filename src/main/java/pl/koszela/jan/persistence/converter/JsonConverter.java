package pl.koszela.jan.persistence.converter;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import pl.koszela.jan.domain.impl.SpecialPrice;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.PriceDTO;
import pl.koszela.jan.persistence.dto.impl.NormalPriceDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductDTO;
import pl.koszela.jan.persistence.dto.impl.SpecialPriceDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class JsonConverter {

  public static final Gson GSON = new Gson();
  private static final String PRODUCT_FILE = "MOCK_DATA_Products.json";
  private static final String NORMAL_PRICES_FILE = "MOCK_DATA_Prices.json";
  private static final String SPECIAL_PRICES_FILE = "MOCK_DATA_Special_Prices.json";
  public String resourcesSamplePath = "src\\main\\resources\\sample\\";

  private DefaultProductDTO[] productDTOS;
  private SpecialPriceDTO[] specialPriceDTOS;
  private NormalPriceDTO[] normalPriceDTOS;

  public JsonConverter(String resourcePath) {
    this.resourcesSamplePath = resourcePath;
  }

  public void convert() {
    convertProducts();
    convertNormalPrices();
    convertSpecialPrices();
  }

  private void convertProducts() {
    String current = null;
    try {
      current = new java.io.File(".").getCanonicalPath();
    } catch (IOException e) {
      e.printStackTrace();
    }

    try (Reader reader = new FileReader(resourcesSamplePath + PRODUCT_FILE)) {

      // Convert JSON to Java Object
      productDTOS = GSON.fromJson(reader, DefaultProductDTO[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void convertSpecialPrices() {
    try (Reader reader = new FileReader(resourcesSamplePath + SPECIAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      specialPriceDTOS = GSON.fromJson(reader, SpecialPriceDTO[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void convertNormalPrices() {
    try (Reader reader = new FileReader(resourcesSamplePath + NORMAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      normalPriceDTOS = GSON.fromJson(reader, NormalPriceDTO[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public ProductDTO[] getProductArray() {
    return this.productDTOS;
  }

  public List<ProductDTO> getProductList() {
    return Arrays.asList(this.productDTOS);
  }

  public PriceDTO[] getSpecialPriceArray() {
    return this.specialPriceDTOS;
  }

  public List<PriceDTO> getSpecialPriceList() {
    return Arrays.asList(this.specialPriceDTOS);
  }

  public List<PriceDTO> getNormalPriceList() {
    return Arrays.asList(normalPriceDTOS);
  }

  public PriceDTO[] getNormalPriceArray() {
    return this.normalPriceDTOS;
  }
}
