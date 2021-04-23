package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository){
        this.repository = repository;
    }

//    {
//        "departmentNumber": 2,
//            "departmentName": "Chris",
//            "managerId": 123
//    }

    @GetMapping("/API/department")
    public List<Department> getDepartmentList(){
        List<Department> departmentList = new ArrayList<>();
        for(Department d : repository.findAll()){
            departmentList.add(d);
        }
        return departmentList;
    }

    @GetMapping("/API/department/{id}")
    public Department getDepartment(@PathVariable Long id, Department department){
        return repository.findOne(id);
    }

    //Create a Department
    @PostMapping("/API/department")
    public Department createDepartment(@RequestBody Department department){
        return repository.save(department);
    }

    //Change the name of a department
    @PutMapping("/API/department/{id}")
    public Department updateDepartmentName(@PathVariable Long id,@RequestBody Department department){
        Department temp = repository.findOne(id);
        temp.setDepartmentName(department.getDepartmentName());
        return repository.save(temp);
    }


    //Merge departments (given two department names eg: A and B, move the manager of B to report to the manager of A, and update all other employees to be members of department A)

}
