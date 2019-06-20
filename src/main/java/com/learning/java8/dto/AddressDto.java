package com.learning.java8.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
public class AddressDto {
    private String id = UUID.randomUUID().toString();
    private String address;
    private String city;
    private String stateOrProvince;
    private String country;
    private String postalCode;
}
