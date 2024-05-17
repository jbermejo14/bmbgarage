package org.bmbgarage.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class Car {
    private int id;
    private String licenseplate;
    private String brand;
    private String carmodel;
    private Date dateregistration;
    private float price;
    private String image;
}
