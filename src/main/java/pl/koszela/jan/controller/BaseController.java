package pl.koszela.jan.controller;

import javax.swing.text.html.HTMLDocument.Iterator;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.koszela.jan.constans.SupermarketAttributeConstans;
import pl.koszela.jan.constans.SupermarketConstans;
import pl.koszela.jan.persistence.converter.JsonConverter;
import pl.koszela.jan.persistence.dto.ProductDTO;
import pl.koszela.jan.persistence.dto.ProductListDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductDTO;
import pl.koszela.jan.persistence.dto.impl.DefaultProductListDTO;
import pl.koszela.jan.service.CartService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
@Controller
public class BaseController {

  private static int counter = 0;
  private static final String VIEW_INDEX = "index";
  private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private CartService cartService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(ModelMap model) {


    model.addAttribute(SupermarketAttributeConstans.SERVLET_NAME_KEY, SupermarketAttributeConstans.SERVLET_NAME_VALUE);
    model.addAttribute("message", "Welcome");
    model.addAttribute("counter", ++counter);
    model.addAttribute("productsDTO", productService.getProducts());
    LOGGER.debug("[welcome] counter : {}", counter);

    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;

  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String welcomeName(@PathVariable String name, ModelMap model,
      @RequestParam(value="product", required=false) String product,
      @RequestParam(value="quantity", required=false) String quantity) {

    model.addAttribute("message", "Welcome " + name);
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);
    return VIEW_INDEX;

  }

}