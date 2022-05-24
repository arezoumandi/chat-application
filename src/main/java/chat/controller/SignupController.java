package chat.controller;

import chat.dao.UserDao;

import chat.forms.SignupForm;
import chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import javax.ws.rs.POST;

@Controller
@RequestMapping("/signup")
public class SignupController {


    @Autowired
    private UserDao userDao;


    @RequestMapping(method = RequestMethod.GET)
    private String action() {
        return "signup";

    }


    @RequestMapping(method = RequestMethod.POST)
    private String getRegister(Model model, @Valid SignupForm signupForm, BindingResult bindingResult) {

        if (bindingResult.hasErrors()) {
            model.addAttribute("signupForm", signupForm);
        } else if (!(signupForm.getPassword().equals(signupForm.getConfirmPassword()))) {
            model.addAttribute("notMatch", "نام کاربری و رمز عبور یکسان نیستند!");

        } else {
            User user = new User();
            //User result = new User();
            user.setName(signupForm.getName());
            user.setUserName(signupForm.getUsername());
            user.setPassword(signupForm.getPassword());
            user.setEmail(signupForm.getEmail());
            user.setSex(signupForm.getSex());
            if (userDao.findByUsername(user.getUserName()) == null) {
                userDao.insert(user);
            } else {
                model.addAttribute("msg", "این نام کاربری قبلا ثبت شده است!");
            }
        }
        System.out.println("register");
        return "signup";

    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(String.class, new StringTrimmerEditor(true));
    }
}
