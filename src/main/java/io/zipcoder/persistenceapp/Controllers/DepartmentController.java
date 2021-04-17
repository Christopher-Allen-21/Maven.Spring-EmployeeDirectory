package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    @Autowired
    private DepartmentRepository repository;

    DepartmentController(DepartmentRepository repository){
        this.repository = repository;
    }

    @PostMapping("/API/department")
    public Department createDepartment(Department department){
        return repository.save(department);
    }

    @PutMapping("/API/department{departmentNumber}")
    public Department updateDepartmentName(@PathVariable Long departmentNumber,Department department){
        Department temp = repository.findOne(departmentNumber);
        temp.setDepartmentName(department.getDepartmentName());
        return repository.save(temp);
    }


}
