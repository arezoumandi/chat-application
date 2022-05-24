package chat.dao;

import chat.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserDaoImp implements UserDao {


    NamedParameterJdbcTemplate namedParameterJdbcTemplate;


    private SqlParameterSource getSqlParameter(User user) {
        MapSqlParameterSource parameterSource = new MapSqlParameterSource();
        parameterSource.addValue("name", user.getName());
        parameterSource.addValue("username", user.getUserName());
        parameterSource.addValue("password", user.getPassword());
        parameterSource.addValue("sex", user.getSex());
        parameterSource.addValue("email", user.getEmail());
        return parameterSource;
    }


    @Autowired
    private void setNamedParameterJdbcTemplate(DataSource dataSource) {
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void insert(User user) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        String sql = "INSERT INTO users(NAME,USERNAME,PASSWORD,SEX,EMAIL) " + "VALUES( :name, :username, :password, :sex, :email)";
        namedParameterJdbcTemplate.update(sql, getSqlParameter(user), keyHolder);
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(int id) {

    }

    @Override
    public List<User> getAllUser() {
        return null;
    }

    @Override
    public User findByUsername(String username) {
        Map<String, String> param = new HashMap<String, String>();
        param.put("username", username);
        User result = null;
        String sql = "select * from users where username=:username";
        try {
             result = namedParameterJdbcTemplate.queryForObject(sql, param, new UserMapper());
        } catch (EmptyResultDataAccessException e) {
            e.printStackTrace();
        }
        return result;

    }

    private static final class UserMapper implements RowMapper<User> {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User();
            user.setName(rs.getString("name"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setSex(rs.getString("sex"));
            user.setId(rs.getInt("user_id"));
            return user;
        }
    }

}
