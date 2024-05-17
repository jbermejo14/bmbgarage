package org.bmbgarage.dao;

import org.bmbgarage.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class UserMapper implements RowMapper<User> {

    @Override
    public User map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new User(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("phone_number"),
                rs.getString("user_password"),
                rs.getString("rol"));
    }
}
