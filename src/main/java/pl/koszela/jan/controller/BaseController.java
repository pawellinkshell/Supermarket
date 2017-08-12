package pl.koszela.jan.controller;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import pl.koszela.jan.constans.SupermarketAttributeConstans;
import pl.koszela.jan.domain.Order;
import pl.koszela.jan.service.OrderService;
import pl.koszela.jan.service.ProductService;

/**
 * Created on 09.08.2017.
 *
 * @author Jan Koszela
 */
@Controller
@EnableWebMvc
public class BaseController {

  private static int counter = 0;
  private static final String VIEW_INDEX = "index";
  private final static org.slf4j.Logger LOGGER = LoggerFactory.getLogger(BaseController.class);

  @Autowired
  private ProductService productService;

  @Autowired
  private OrderService orderService;

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(ModelMap model) {

    model.addAttribute(SupermarketAttributeConstans.SERVLET_NAME.getKey(),
        SupermarketAttributeConstans.SERVLET_NAME.getValue());
    model.addAttribute(SupermarketAttributeConstans.ADD_DOMAIN_NAME.getKey(),
        SupermarketAttributeConstans.ADD_DOMAIN_NAME.getValue());
    model.addAttribute("message", "Welcome");
    model.addAttribute("counter", ++counter);
    model.addAttribute("productsDTO", productService.getProducts());
    LOGGER.debug("[welcome] counter : {}", counter);

    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;

  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String welcomeName(@PathVariable String name, ModelMap model,
            @RequestParam(value = "product", required = false) String product,
      @RequestParam(value = "quantity", required = false) String quantity) {

      Order foundOrder = orderService.findOrderByName(product);
      if (foundOrder == null) {
        Order newOrder = new Order(product, Integer.valueOf(quantity));
        orderService.createOrder(newOrder);
      } else {
        if(foundOrder.getQuantity() != Integer.valueOf(quantity)){
          Order newOrder = new Order(product, Integer.valueOf(quantity));
          orderService.updateOrder(newOrder);
        }
      }

    model.addAttribute("message", "Welcome " + name);
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);
    return VIEW_INDEX;

  }

//  @RequestMapping(value = "/add", method = RequestMethod.GET)
//  public String addName(@PathVariable String name, ModelMap model,
//      @RequestParam(value = "product", required = false) String product,
//      @RequestParam(value = "quantity", required = false) String quantity) {
//
//
//
////    Order order = Order.builder()
////        .productName(product)
////        .quantity(quantity)
////        .build();
////
////    Cart cart = Cart.builder()
////        .productName(product)
////        .quantity(quantity)
////        .build();
//
//    model.addAttribute("message", "Welcome " + name);
//    model.addAttribute("counter", ++counter);
//    LOGGER.debug("[welcomeName] counter : {}", counter);
//    return VIEW_INDEX;
//
//  }

}