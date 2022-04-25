package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final LoginProcessor loginProcessor = new LoginProcessor();

    @GetMapping("/")
    public String loginGet(){
        return "login.html";
    }

    @PostMapping("/")
    public String loginPost(
            @RequestParam String username,
            @RequestParam String password,
            Model model
    ){
        loginProcessor.setUsername(username);
        loginProcessor.setPassword(password);
        boolean loggedIn = loginProcessor.login();

        if(loggedIn){
            model.addAttribute("message", "Hello "+ username +" You are now logged In :)");
        }else{
            model.addAttribute("message", "Login Failed!");
        }
        return "login.html";
    }
}
