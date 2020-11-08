package com.spring.h2.api.service;

import com.spring.h2.api.model.Employee;
import com.spring.h2.api.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmployeeServiceImpl implements  EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee addEmp(Employee employee) {

        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployee(int id)  {
         Optional<Employee> employee = employeeRepository.findById(id);
        // return employeeRepository.findById(id).orElseThrow(()-> new Exception("not found"+id));
       return employee;
    }
}
