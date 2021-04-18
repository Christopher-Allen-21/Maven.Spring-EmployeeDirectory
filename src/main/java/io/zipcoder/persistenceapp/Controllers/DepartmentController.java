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

    @PostMapping("/API/department")
    public Department createDepartment(Department department){
        return repository.save(department);
    }

    @PutMapping("/API/department/{id}")
    public Department updateDepartmentName(@PathVariable Long id,Department department){
        Department temp = repository.findOne(id);
        temp.setDepartmentName(department.getDepartmentName());
        return repository.save(temp);
    }


}
