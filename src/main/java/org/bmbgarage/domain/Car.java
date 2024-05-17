package org.bmbgarage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int id;
    private User user;
    private String license_plate;
    private String brand;
    private String car_model;
    private int date_registration;
    private float price;
    private String image;
}
