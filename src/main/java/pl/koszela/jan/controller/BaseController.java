package pl.koszela.jan.controller;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

  @RequestMapping(value = "/", method = RequestMethod.GET)
  public String welcome(ModelMap model) {

    model.addAttribute("message", "Welcome");
    model.addAttribute("counter", ++counter);
    model.addAttribute("productDTO", "Mustang");
    LOGGER.debug("[welcome] counter : {}", counter);

    // Spring uses InternalResourceViewResolver and return back index.jsp
    return VIEW_INDEX;

  }

  @RequestMapping(value = "/{name}", method = RequestMethod.GET)
  public String welcomeName(@PathVariable String name, ModelMap model) {

    model.addAttribute("message", "Welcome " + name);
    model.addAttribute("counter", ++counter);
    LOGGER.debug("[welcomeName] counter : {}", counter);
    return VIEW_INDEX;

  }

}