package chat.dao;

import chat.model.Messages;
import chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import java.util.HashMap;
import java.util.Map;

public class MessageDaoImp implements MessageDao {

    NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    @Autowired
    UserDao userDao;

    @Override
    public void insertMessage(Messages message) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO messages(MESSAGE,SENDER_ID) " + "VALUES( :message, :sender_id)";
        namedParameterJdbcTemplate.update(sql, getSqlParameter(message), keyHolder);

    }

    @Override
    public void findMessageByUsername(String username) {

    }


    @Override
    public Integer findUserId(String username) {
        User user;
        user=userDao.findByUsername(username);
        System.out.println("dfasdf"+ user.getId());
        Integer id=user.getId();
        return id;
    }

    private SqlParameterSource getSqlParameter(Messages messages) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("message", messages.getMessage());
        parameterSource.addValue("sender_id",messages.getSender_id());

        return parameterSource;
    }
}

