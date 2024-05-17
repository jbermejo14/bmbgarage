package org.bmbgarage.dao;

import org.bmbgarage.domain.Car;
import org.bmbgarage.domain.Client;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {

        Client client = Database.jdbi.withExtension(ClientDao.class, dao -> dao.getClient(rs.getInt("id")));

        return new Car(rs.getInt("id"),
                client,
                rs.getString("license_plate"),
                rs.getString("brand"),
                rs.getString("carmodel"),
                rs.getInt("dateregistration"),
                rs.getFloat("price"),
                rs.getString("image"));
    }
}

