package main;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
/*
 The @Controller stereotype annotation marks this class as Spring MVC controller
 and adds a bean of this type to the Spring context.
 */
@Controller
public class MainController {
    @RequestMapping("/")
    // The action method defines a parameter of type Model that stores the data the controller sends to the view.
    public String home(Model page){
        page.addAttribute("username", "Katy");
        page.addAttribute("color", "red");
        return "home.html";
    }
}
