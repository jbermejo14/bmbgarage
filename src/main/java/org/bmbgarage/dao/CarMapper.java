package org.bmbgarage.dao;

import org.bmbgarage.domain.Car;
import org.bmbgarage.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {

        return new Car(rs.getInt("id"),
                rs.getString("license_plate"),
                rs.getString("brand"),
                rs.getString("model"),
                rs.getString("country"),
                rs.getInt("year"),
                rs.getFloat("price"),
                rs.getString("photo"));
    }
}

