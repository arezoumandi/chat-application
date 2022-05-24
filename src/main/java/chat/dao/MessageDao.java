package chat.dao;

import chat.model.Messages;

public interface MessageDao {

    public void insertMessage(Messages message);
    public void findMessageByUsername(String username);
    public Integer  findUserId(String username);

}
