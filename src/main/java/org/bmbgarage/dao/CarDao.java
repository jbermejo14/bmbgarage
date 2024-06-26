package org.bmbgarage.dao;

import org.bmbgarage.domain.Car;
import org.bmbgarage.domain.Client;
import org.jdbi.v3.sqlobject.customizer.Bind;
import org.jdbi.v3.sqlobject.statement.SqlQuery;
import org.jdbi.v3.sqlobject.statement.SqlUpdate;
import org.jdbi.v3.sqlobject.statement.UseRowMapper;

import java.sql.Date;
import java.util.List;

public interface CarDao {

    @SqlQuery("SELECT * FROM Cars")
    @UseRowMapper(CarMapper.class)
    List<Car> getAllCars();

    @SqlQuery("SELECT * FROM Cars WHERE id = ?")
    @UseRowMapper(CarMapper.class)
    Car getCar(int id);

    @SqlQuery("SELECT * FROM Cars WHERE brand LIKE '%' || :searchTerm || '%' ")
    @UseRowMapper(CarMapper.class)
    List<Car> getCars(@Bind("searchTerm") String searchTerm);

    @SqlUpdate("INSERT INTO cars (licenseplate, brand, carmodel, dateregistration, price, image) VALUES (?, ?, ?, ?, ?, ?)")
    int addCar(String licenseplate, String brand, String carmodel, int dateregistration, float price, String image);

    @SqlUpdate("UPDATE cars SET licenseplate = ?, brand = ?, carmodel = ?, dateregistration = ?, price = ?, image = ? WHERE id = ?")
    int updateCar(String licenseplate, String brand, String carmodel, int dateregistration, float price, String image, int id);

    @SqlUpdate("DELETE FROM cars WHERE id = ?")
    int removeCar(int id);

}
