package com.example.MicroserviceOne.response;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddressResponse {
    private int id;
    private String city;
    private String state;
}