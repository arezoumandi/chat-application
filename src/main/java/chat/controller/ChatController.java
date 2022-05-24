package chat.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller()
@RequestMapping("/chat")
public class ChatController {

    @RequestMapping(method =  RequestMethod.GET)
    public  String doGet()
    {
        return "chat";
    }

    @RequestMapping(method = RequestMethod.POST)
    public  String doPost()
    {
        return "chat";
    }
}
