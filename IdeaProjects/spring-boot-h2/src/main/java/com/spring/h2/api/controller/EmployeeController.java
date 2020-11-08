package com.spring.h2.api.controller;


import com.spring.h2.api.exception.EmployeeNotFoundException;
import com.spring.h2.api.model.Employee;
import com.spring.h2.api.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {


    @Autowired
    private EmployeeService employeeService;

    @PostMapping("/add")
    public ResponseEntity<Employee> add(@RequestBody Employee employee){
       try{
           Employee employee1= employeeService.addEmp(employee);
           return new ResponseEntity<>(employee1, HttpStatus.CREATED);
       }catch (Exception ex){
           return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
       }

    }
    @GetMapping("/getEmployee/{id}")
    public Employee getEmployee(@PathVariable("id") int id) {
        return employeeService.getEmployee(id).orElseThrow(()->new EmployeeNotFoundException("not found"+ id));
    }
}
