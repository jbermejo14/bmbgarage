package org.bmbgarage.dao;
import org.bmbgarage.domain.User;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;
import java.util.List;

public interface UserDao {

    @SqlQuery("SELECT * FROM users")
    @UseRowMapper(org.bmbgarage.dao.UserMapper.class)
    List<User> getAllUsers();

    @SqlQuery("SELECT * FROM users WHERE id = ?")
    @UseRowMapper(org.bmbgarage.dao.UserMapper.class)
    User getUser(int id);

    @SqlQuery("SELECT * FROM users WHERE username = ? AND password = ?")
    @UseRowMapper(org.bmbgarage.dao.UserMapper.class)
    User getUser(String username, String password);

    @SqlUpdate("INSERT INTO users (username, email, phonenumber, userpassword, role) VALUES (?, ?, ?, ?, ?)")
    int addUser(String username, String email, String phonenumber, String userpassword, String role);

    @SqlUpdate("UPDATE users SET username = ?, password = ?, telephone = ? WHERE id = ?")
    int updateUser(String username, String password, int telephone, int id);

    @SqlUpdate("DELETE FROM users WHERE id = ?")
    int removeUser(int id);
}