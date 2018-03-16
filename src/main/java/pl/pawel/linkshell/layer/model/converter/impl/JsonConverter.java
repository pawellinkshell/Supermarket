package pl.pawel.linkshell.layer.model.converter.impl;

import com.google.gson.Gson;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Objects;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.pawel.linkshell.layer.model.converter.Converter;
import pl.pawel.linkshell.layer.model.domain.impl.Item;
import pl.pawel.linkshell.layer.model.domain.impl.SpecialPrice;
import pl.pawel.linkshell.layer.model.domain.impl.StockPrice;

/**
 * Created on 10.08.2017.
 */
public class JsonConverter implements Converter {

  private static final Gson GSON = new Gson();
  private static final String PRODUCT_FILE = "sample/MOCK_DATA_Items.json";
  private static final String NORMAL_PRICES_FILE = "sample/MOCK_DATA_Prices.json";
  private static final String SPECIAL_PRICES_FILE = "sample/MOCK_DATA_Special_Prices.json";
  private final String resourcesSamplePath;

  private static final Logger LOGGER = LoggerFactory.getLogger(JsonConverter.class);

  public JsonConverter() {
    this.resourcesSamplePath =
        Objects.requireNonNull(
            Thread.currentThread().getContextClassLoader().getResource("/"))
            .getPath();
  }

  @Override
  public Item[] convertItems() {
    Item[] items = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + PRODUCT_FILE)) {

      // Convert JSON to Java Object
      items = GSON.fromJson(reader, Item[].class);

    } catch (FileNotFoundException e) {
      LOGGER.error("File not found: {}", e.getMessage());
    } catch (IOException e) {
      LOGGER.error("Problem reading from file: {}", e.getMessage());
    }

    return items;
  }

  @Override
  public SpecialPrice[] convertSpecialPrices() {
    SpecialPrice[] specialPrices = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + SPECIAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      specialPrices = GSON.fromJson(reader, SpecialPrice[].class);

    } catch (FileNotFoundException e) {
      LOGGER.error("File not found: {}", e.getMessage());
    } catch (IOException e) {
      LOGGER.error("Problem reading from file: {}", e.getMessage());
    }

    return specialPrices;
  }

  @Override
  public StockPrice[] convertNormalPrices() {
    StockPrice[] stockPrices = null;
    try (Reader reader = new FileReader(this.resourcesSamplePath + NORMAL_PRICES_FILE)) {

      // Convert JSON to Java Object
      stockPrices = GSON.fromJson(reader, StockPrice[].class);

    } catch (FileNotFoundException e) {
      LOGGER.error("File not found: {}", e.getMessage());
    } catch (IOException e) {
      LOGGER.error("Problem reading from file: {}", e.getMessage());
    }

    return stockPrices;
  }

}
