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

//    {
//        "employeeId": 1,
//        "firstName": "Chris",
//        "lastName": "Allen",
//        "title": "Associate",
//        "phoneNumber": "240-688-1234",
//        "email": "thisIsAnnoying@yahoo.com",
//        "hireDate": "2021-05-15",
//        "departmentNumber": 123,
//        "manager": null
//    }


    @GetMapping("/API/employee")
    public List<Employee> getEmployeeList(){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            employeeList.add(e);
        }
        return employeeList;
    }

    //Get the department, title, or other attributes of a particular employee.
    @GetMapping("/API/employee/{id}")
    public Employee getEmployee(@PathVariable Long id){
        return repository.findOne(id);
    }

    // Create employee (Via POST)
    @PostMapping("/API/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return repository.save(employee);
    }

    //Update an employee to set their manager
    @PutMapping("/API/employee/manager/{id}")
    public Employee updateEmployeeManager(@PathVariable Long id,@RequestBody Employee employee){
        Employee temp = repository.findOne(id);
        temp.setManagerId(employee.getManagerId());
        return repository.save(temp);
    }

    //Update other employee fields
    @PutMapping("/API/employee/{id}")
    public Employee updateAll(@PathVariable Long id,@RequestBody Employee employee){
        Employee temp = repository.findOne(id);
        temp.setFirstName(employee.getFirstName());
        temp.setLastName(employee.getLastName());
        temp.setTitle(employee.getTitle());
        temp.setPhoneNumber(employee.getPhoneNumber());
        temp.setEmail(employee.getEmail());
        temp.setHireDate(employee.getHireDate());
        temp.setManagerId(employee.getManagerId());
        temp.setDepartmentNumber(employee.getDepartmentNumber());
        return repository.save(temp);
    }

    //Set a new department manager (Update department)
    @PutMapping("/API/employee/departmentNumber/{id}")
    public Employee updateEmployeeDepartmentNumber(@PathVariable Long id,@RequestBody Employee employee){
        Employee temp = repository.findOne(id);
        temp.setDepartmentNumber(employee.getDepartmentNumber());
        return repository.save(temp);
    }

    //MIGHT NOT WORK
    //Get the list of employees under a particular manager
    @GetMapping("/API/employee/employeesUnderManager/{managerId}")
    public List<Employee> getEmployeesUnderManager(@PathVariable Long managerId){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            if(e.getManagerId() == managerId){
                employeeList.add(e);
            }
        }
        return employeeList;
    }


    //Get a list of employees with no assigned manager
    @GetMapping("/API/employee/employeesWithNoManager")
    public List<Employee> getEmployeesWithNoAssignedManager(){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            if(e.getManagerId() == null){
                employeeList.add(e);
            }
        }
        return employeeList;
    }


    //Get all employees of a particular department
    @GetMapping("/API/employee/employeesInDepartment/{departmentNumber}")
    public List<Employee> getEmployeesInDepartment(@PathVariable Long departmentNumber){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            if(e.getDepartmentNumber() == departmentNumber){
                employeeList.add(e);
            }
        }
        return employeeList;
    }

    //Remove a particular employee
    @DeleteMapping("/API/employee/deleteEmployee/{id}")
    public Boolean deleteEmployee(@PathVariable Long id){
        repository.delete(id);
        return true;
    }

    //Remove a list of employees
    @DeleteMapping("/API/employee/deleteEmployee")
    public Boolean deleteAllEmployees(){
        repository.deleteAll();
        return true;
    }

    //Remove all employees from a particular department
    @DeleteMapping("/API/employee/deleteEmployeeInDepartment/{departmentNumber}")
    public Boolean deleteEmployeesInDepartment(@PathVariable Long departmentNumber){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            if(e.getDepartmentNumber() == departmentNumber){
                employeeList.add(e);
            }
        }
        repository.delete(employeeList);
        return true;
    }

    //Remove all employees under a particular manager (Including indirect reports)
    @DeleteMapping("/API/employee/deleteEmployeeUnderManager/{manager}")
    public Boolean deleteEmployeesUnderManager(@PathVariable String manager){
        List<Employee> employeeList = new ArrayList<>();
        for(Employee e : repository.findAll()){
            if(e.getManagerId()!=null && e.getManagerId().equals(manager)){
                employeeList.add(e);
            }
        }
        repository.delete(employeeList);
        return true;
    }

//    @GetMapping("/API/employee/reportingHierarchy/{id}")
//    public List<Employee> getReportingHierarchy(@PathVariable Long id){
//        List<Employee> employeeList = new ArrayList<>();
//        Employee currentEmployee = repository.findOne(id);
//        while(currentEmployee.getManager() != null){
//            employeeList.add(currentEmployee);
//            currentEmployee = currentEmployee.getManager();
//        }
//        return employeeList;
//    }



    //Get the entire reporting hierarchy for an employee (their manager + manager's manager etc.)

    //Get all employees who report directly or indirectly to a particular manager. This should still work for an employee who is not a manager -- they have no direct reports


    //Remove all direct reports to a manager. Any employees previously managed by the deleted employees should now be managed by the next manager up the hierarchy.




}
