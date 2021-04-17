package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private EmployeeRepository repository;

    public EmployeeService(EmployeeRepository employeeRepository){
        this.repository = employeeRepository;
    }

    public Iterable<Employee> index(){
         return repository.findAll();
    }

    public Employee show(Long employeeNumber){
        return repository.findOne(employeeNumber);
    }

    public Employee create(Employee employee){
        return repository.save(employee);
    }

    public Employee update(Long employeeNumber,Employee employee){
        Employee originalEmployee = repository.findOne(employeeNumber);
        originalEmployee.setFirstName(originalEmployee.getFirstName());
        originalEmployee.setLastName(originalEmployee.getLastName());
        originalEmployee.setTitle(originalEmployee.getTitle());
        originalEmployee.setPhoneNumber(originalEmployee.getPhoneNumber());
        originalEmployee.setEmail(originalEmployee.getEmail());
        originalEmployee.setManager(originalEmployee.getManager());
        originalEmployee.setDepartmentNumber(originalEmployee.getDepartmentNumber());
        return repository.save(originalEmployee);
    }

    public Boolean delete(Long employeeNumber){
        repository.delete(employeeNumber);
        return true;
    }


}
