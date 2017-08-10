package pl.koszela.jan.persistence.converter;

import com.google.gson.Gson;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Arrays;
import java.util.List;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.SpecialPriceDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductListDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultSpecialPriceDTO;

/**
 * Created on 10.08.2017.
 *
 * @author Jan Koszela
 */
public class JsonConverter {

  public static final Gson GSON = new Gson();
  private static final String PRODUCT_FILE = "MOCK_DATA_Products.json";
  private static final String SPECIAL_PRICES_FILE = "MOCK_DATA_Special_Prices.json";
  public static final String RESOURCES_SAMPLE_PATH = "src\\main\\resources\\sample\\";

  private DefaultProductDTO[] productDTOS;
  private DefaultSpecialPriceDTO[] specialPriceDTOS;

  public static void main(String[] args) {

    try (Reader reader = new FileReader(RESOURCES_SAMPLE_PATH + PRODUCT_FILE)) {

      // Convert JSON to Java Object
      DefaultProductDTO[] productDTOS = GSON.fromJson(reader, DefaultProductDTO[].class);

      for (int i = 0; i < productDTOS.length; i++) {
        System.out.println(productDTOS[i]);
      }

      DefaultProductListDTO productList = new DefaultProductListDTO();
      productList.setProducts(Arrays.asList(productDTOS));

      System.out.println(productList);
    } catch (IOException e) {
      e.printStackTrace();
    }

  }

  public void convert() {
    convertProducts();
    convertSpecialPrices();
  }

  private void convertProducts() {
    try (Reader reader = new FileReader(RESOURCES_SAMPLE_PATH + PRODUCT_FILE)) {

      // Convert JSON to Java Object
      productDTOS = GSON.fromJson(reader, DefaultProductDTO[].class);

    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private void convertSpecialPrices() {
    try (Reader reader = new FileReader(RESOURCES_SAMPLE_PATH + SPECIAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      specialPriceDTOS = GSON.fromJson(reader, DefaultSpecialPriceDTO[].class);

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

  public SpecialPriceDTO[] getSpecialPriceArray() {
    return this.specialPriceDTOS;
  }

  public List<SpecialPriceDTO> getSpecialPriceList() {
    return Arrays.asList(this.specialPriceDTOS);
  }

}
