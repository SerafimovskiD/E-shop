package mk.ukim.finki.webaud.web.controller;

import mk.ukim.finki.webaud.model.exception.InvalidArgumentsExecption;
import mk.ukim.finki.webaud.model.exception.PasswordsDoNotMatchException;
import mk.ukim.finki.webaud.service.AuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/register")
public class RegisterController {
    private final AuthService authService;

    public RegisterController(AuthService authService) {
        this.authService = authService;
    }
    @GetMapping
    public String getRegisterPage(@RequestParam(required = false) String error, Model model){
        if(error!=null && !error.isEmpty()){
            model.addAttribute("hasError",true);
            model.addAttribute("error",error);
        }
        return "register";
    }

    @PostMapping
    public String Register(@RequestParam String username,
                           @RequestParam String password,
                           @RequestParam String name,
                           @RequestParam String surname,
                           @RequestParam String repeatPassword){
        try{
            this.authService.register(username,password,repeatPassword,name,surname);
            return "redirect:/login";
        }catch (PasswordsDoNotMatchException | InvalidArgumentsExecption ex){
            return "redirect:/register?error="+ex.getMessage();
        }
    }
}
