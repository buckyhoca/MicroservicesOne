package com.example.MicroserviceOne.service;

import com.example.MicroserviceOne.response.EmployeeResponse;

public interface EmployeeService {
    EmployeeResponse getEmployeeById(int id);
}
