package chat.spring;

import chat.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class ChatUserDeta implements UserDetailsService {

    @Autowired
    UserDao userDao;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        chat.model.User user;
        user=userDao.findByUsername(username);
        if (user==null)
        {
            throw new UsernameNotFoundException("username not found");
        }
        else{
        List<GrantedAuthority> roles = new ArrayList<GrantedAuthority>();
        roles.add(new SimpleGrantedAuthority("ROLE_USER"));
        UserDetails userDetails = new User(user.getUserName(),user.getPassword(), true, true, true, true, roles);
        return userDetails;}
    }


}
