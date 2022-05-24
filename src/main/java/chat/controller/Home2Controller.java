package chat.controller;

import chat.forms.MessageForm;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.security.Principal;
import java.util.Enumeration;

@Controller
@RequestMapping("/home2")
public class Home2Controller {





    @RequestMapping( method=RequestMethod.POST)
    private String getHome(Model model,MessageForm messageForm ) {
        System.out.println("post");
       /* System.out.println("post" + messageForm.getUsername());
        Integer id;
        id = messageDao.findUserId(messageForm.getUsername());
        Messages messages = null;
        System.out.println("message: " + messageForm.getMessage());
        if (messages != null) {
            messages.setSender_id(id);
            messages.setMessage(messageForm.getMessage());
        }


        messageDao.insertMessage(messages);*/

       // User u = (User) ((Authentication) principal).getPrincipal();
       // HttpSession session = request.getSession();
       // System.out.println(SecurityContextHolder.getContext().getClass());
        //Enumeration<String> attribs = session.getAttributeNames();
        // attrib = attribs.nextElement();
      /*  System.out.println("---->");
        while (attribs.hasMoreElements()) {
            System.out.println(attrib + " -> " + session.getAttribute(attrib));
            attrib = attribs.nextElement();
        }*/
        //model.addAttribute("u", u);
        System.out.println("post:"+MessageForm.myUsername);
        return "home2";
    }


    @RequestMapping(method = RequestMethod.GET)
    private String postHome(Model model, Principal principal, HttpServletRequest request,String myMessage) {
        User u = (User) ((Authentication) principal).getPrincipal();
        HttpSession session = request.getSession();
        System.out.println(SecurityContextHolder.getContext().getClass());
        Enumeration<String> attribs = session.getAttributeNames();
        /*String attrib = attribs.nextElement();
        System.out.println("---->");
        while (attribs.hasMoreElements()) {
            System.out.println(attrib + " -> " + session.getAttribute(attrib));
            attrib = attribs.nextElement();
        }
        System.out.println("<-----");
        model.addAttribute("u", u);
        System.out.println("<-----");
        model.addAttribute("u", u);
        List<String> listOfUsers=new ArrayList<String>();
        listOfUsers.add(u.getUsername());
        model.addAttribute("list",listOfUsers);
        System.out.println("message : "+ messageForm.getMyMessage());*/


        model.addAttribute("u", u);

        return "home2";
    }
}

