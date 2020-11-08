package com.spring.h2.api.service;

import com.spring.h2.api.model.Employee;

import java.util.Optional;

public interface EmployeeService {

    Employee addEmp(Employee employee);

    Optional<Employee> getEmployee(int id);
}
