package com.example.MicroserviceOne.service.impl;

import com.example.MicroserviceOne.entity.Employee;
import com.example.MicroserviceOne.feignclient.AddressClient;
import com.example.MicroserviceOne.repository.EmployeeRepo;
import com.example.MicroserviceOne.response.AddressResponse;
import com.example.MicroserviceOne.response.EmployeeResponse;
import com.example.MicroserviceOne.service.EmployeeService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private ModelMapper mapper;

    @Autowired
    private AddressClient addressClient;

    public EmployeeResponse getEmployeeById(int id) {

        Optional<Employee> employee = employeeRepo.findById(id);
        System.out.println("The employee: " + employee);
        EmployeeResponse employeeResponse = null;

        if(employee.isPresent()){
            employeeResponse = mapper.map(employee, EmployeeResponse.class);
        }

        ResponseEntity<AddressResponse> addressResponse = addressClient.getAddressByEmployeeId(id);
        AddressResponse body = addressResponse.getBody();

        if (body != null) {
            // Response body is not empty, proceed with setting the address response
            assert employeeResponse != null;
            employeeResponse.setAddressResponse(body);
        }
        return employeeResponse;
    }
}
