package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository repository;

    public EmployeeController(EmployeeRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/API/employee")
    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            employeeList.add(e);
        }
        return employeeList;
    }

    @GetMapping("/API/employee/{employeeNumber}")
    public Employee getEmployee(@PathVariable Long employeeNumber){
        return repository.findOne(employeeNumber);
    }

    @PostMapping("/API/employee")
    public Employee createEmployee(Employee employee){
        return repository.save(employee);
    }

    @PutMapping("/API/employee/manager/{employeeNumber}")
    public Employee updateEmployeeManager(@PathVariable Long employeeNumber,Employee employee){
        Employee temp = repository.findOne(employeeNumber);
        temp.setManager(employee.getManager());
        return repository.save(temp);
    }

    @PutMapping("/API/employee/{employeeNumber}")
    public Employee updateAll(@PathVariable Long employeeNumber,Employee employee){
        Employee temp = repository.findOne(employeeNumber);
        temp.setFirstName(employee.getFirstName());
        temp.setLastName(employee.getLastName());
        temp.setTitle(employee.getTitle());
        temp.setPhoneNumber(employee.getPhoneNumber());
        temp.setEmail(employee.getEmail());
        temp.setHireDate(employee.getHireDate());
        temp.setManager(employee.getManager());
        temp.setDepartmentNumber(employee.getDepartmentNumber());
        return repository.save(temp);
    }

    @PutMapping("/API/employee/departmentnumber/{employeeNumber}")
    public Employee updateEmployeeDepartmentNumber(@PathVariable Long employeeNumber,Employee employee){
        Employee temp = repository.findOne(employeeNumber);
        temp.setDepartmentNumber(employee.getDepartmentNumber());
        return repository.save(temp);
    }


}
