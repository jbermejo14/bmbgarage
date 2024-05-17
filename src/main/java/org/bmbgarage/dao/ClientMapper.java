package org.bmbgarage.dao;

import org.bmbgarage.domain.Client;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ClientMapper implements RowMapper<Client> {

    @Override
    public Client map(ResultSet rs, StatementContext ctx) throws SQLException {
        return new Client(rs.getInt("id"),
                rs.getString("username"),
                rs.getString("email"),
                rs.getString("phonenumber"),
                rs.getString("userpassword"),
                rs.getString("rol"));
    }
}
