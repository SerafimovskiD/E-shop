package mk.ukim.finki.webaud.web.controller;

import jakarta.servlet.http.HttpServletRequest;
import mk.ukim.finki.webaud.model.User;
import mk.ukim.finki.webaud.model.exception.InvalidUserCredentialException;
import mk.ukim.finki.webaud.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller //-> vrakja nekakvo view
//@RestController// -> vrakja nekakvi podatoci
@RequestMapping("/login")
public class LoginController {
    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping
    public String getLoginPage(){
        return "login";
    }
    @PostMapping
    public String login(HttpServletRequest request, Model model){
        User user=null;
        try{
            user=this.authService.login(request.getParameter("username"),request.getParameter("password"));
            request.getSession().setAttribute("user",user);
            return "redirect:/home";
        }
        catch(InvalidUserCredentialException ex){
            model.addAttribute("hasError",true);
            model.addAttribute("error",ex.getMessage());
            return "/login";
        }
    }
}
