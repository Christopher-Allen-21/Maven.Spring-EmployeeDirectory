package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;

public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }

    public Iterable<Employee> index(){
         return repository.findAll();
    }

}
