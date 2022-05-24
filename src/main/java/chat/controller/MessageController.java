package chat.controller;


import chat.dao.MessageDao;
import chat.dao.UserDao;
import chat.forms.MessageForm;
import chat.model.Messages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


public class MessageController {

    @Autowired
    MessageDao messageDao;
    public void saveMessage(Model model , MessageForm messageForm)
    {
        Integer id;
        id=messageDao.findUserId(messageForm.getUsername());
        Messages messages=null;
        messages.setId(id);
        //messages.setMessage(messageForm.getMessage());
        messageDao.insertMessage(messages);

    }


}
