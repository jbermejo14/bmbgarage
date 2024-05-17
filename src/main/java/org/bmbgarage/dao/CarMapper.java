package org.bmbgarage.dao;

import org.bmbgarage.domain.Car;
import org.bmbgarage.dao.Database;
import org.bmbgarage.domain.User;
import org.jdbi.v3.core.mapper.RowMapper;
import org.jdbi.v3.core.statement.StatementContext;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CarMapper implements RowMapper<Car> {

    @Override
    public Car map(ResultSet rs, StatementContext ctx) throws SQLException {

        User user = Database.jdbi.withExtension(UserDao.class, dao -> dao.getUser(rs.getInt("id")));

        return new Car(rs.getInt("id"),
                user,
                rs.getString("license_plate"),
                rs.getString("brand"),
                rs.getString("car_model"),
                rs.getInt("date_registration"),
                rs.getFloat("price"),
                rs.getString("image"));
    }
}

