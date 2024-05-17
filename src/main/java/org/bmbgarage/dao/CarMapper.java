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

        return new Car(rs.getInt("id"),
                rs.getString("licenseplate"),
                rs.getString("brand"),
                rs.getString("carmodel"),
                rs.getDate("dateregistration"),
                rs.getFloat("price"),
                rs.getString("image"));
    }
}

