
package hitado.apps.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloController {

    @RequestMapping(value = "/hello")
    public ModelAndView hello() {
        return new ModelAndView("helloView");
    }

    @RequestMapping(value = "/welcome")
    public ModelAndView welcome() {
        return new ModelAndView("welcomeView");
    }

}
