package org.bmbgarage.dao;
import org.bmbgarage.domain.User;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import java.util.List;

public interface UserDao {

    @SqlQuery("SELECT * FROM users")
    @UseRowMapper(com.bermecar.dao.UserMapper.class)
    List<User> getAllUsers();

    @SqlQuery("SELECT * FROM users WHERE id = ?")
    @UseRowMapper(com.bermecar.dao.UserMapper.class)
    User getUser(int id);

    @SqlQuery("SELECT * FROM users WHERE username = ? AND password = ?")
    @UseRowMapper(com.bermecar.dao.UserMapper.class)
    User getUser(String username, String password);

    @SqlUpdate("INSERT INTO users (username, password, telephone, role) VALUES (?, ?, ?, ?)")
    int addUser(String username, String password, int telephone, String role);

    @SqlUpdate("UPDATE users SET username = ?, password = ?, telephone = ? WHERE id = ?")
    int updateUser(String username, String password, int telephone, int id);

    @SqlUpdate("DELETE FROM users WHERE id = ?")
    int removeUser(int id);
}