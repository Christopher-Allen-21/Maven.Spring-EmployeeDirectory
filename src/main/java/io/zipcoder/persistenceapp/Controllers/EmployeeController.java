package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Services.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }


    @GetMapping("/employee")
    public ResponseEntity<Iterable<Employee>> index() {
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }


    @GetMapping("/employee/{employeeNumber}")
    public ResponseEntity<Employee> show(@PathVariable Long employeeNumber) {
        return new ResponseEntity<>(service.show(employeeNumber), HttpStatus.OK);
    }


    @PostMapping("/employee")
    public ResponseEntity<Employee> create(Employee employee) {
        return new ResponseEntity<>(service.create(employee), HttpStatus.CREATED);
    }


    @PutMapping("/employee/{employeeNumber}")
    public ResponseEntity<Employee> update(@PathVariable Long employeeNumber, Employee employee) {
        return new ResponseEntity<>(service.update(employeeNumber, employee), HttpStatus.OK);
    }


    @DeleteMapping("/employee/{employeeNumber}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long employeeNumber) {
        return new ResponseEntity<>(service.delete(employeeNumber), HttpStatus.OK);
    }

}
