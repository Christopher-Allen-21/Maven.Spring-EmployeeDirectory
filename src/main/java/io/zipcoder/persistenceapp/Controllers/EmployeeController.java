package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }


    @PostMapping("/API/employee")
    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    @PutMapping("/API/employee/manager{employeeNumber}")
    public Employee updateEmployeeManager(@PathVariable long employeeNumber,Employee employee){
        Employee temp = repository.findOne(employeeNumber);
        temp.setManager(employee.getManager());
        return repository.save(temp);
    }



}
