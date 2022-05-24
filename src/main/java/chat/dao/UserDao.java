package chat.dao;

import chat.model.User;

import java.util.List;

public interface UserDao {
    void insert (User user);
    void update(User user);
    void delete (int id);
    List<User> getAllUser();
    User findByUsername(String username);
}
