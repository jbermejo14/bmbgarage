package org.bmbgarage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int id;
    private Client client;
    private String license_plate;
    private String brand;
    private String carmodel;
    private int dateregistration;
    private float price;
    private String image;
}
