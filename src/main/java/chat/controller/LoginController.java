package chat.controller;

import chat.forms.LoginForm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import javax.validation.Valid;
import java.lang.reflect.Method;
import java.util.Objects;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    @Qualifier("authenticationManager")
    private AuthenticationManager authenticationManager;

    @RequestMapping(method = RequestMethod.GET)
    private String doGet()
    {
        return "login";
    }

    @RequestMapping(method = RequestMethod.POST)
    private Object login(Model model,@Valid LoginForm loginForm , BindingResult bindingResult)
    {

        if(bindingResult.hasErrors())
        {
            model.addAttribute("loginForm",loginForm);
            System.out.println("errrror");
            return "login";
        }

      /* try {
            Authentication authentication=authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginForm.getUsername(),loginForm.getPassword()));
            SecurityContextHolder.getContext().setAuthentication(authentication);
            System.out.println(authentication.getName());
            System.out.println("ysd");
        }catch (Exception e){
            e.printStackTrace();
            return ("login");
        }*/

       // User user = (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        //String username = user.getUsername();
        //System.out.println(username);
        //System.out.println("1233");
        return new RedirectView("/home");
    }
}
