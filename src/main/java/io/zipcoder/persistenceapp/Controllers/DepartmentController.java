package io.zipcoder.persistenceapp.Controllers;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Services.DepartmentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
public class DepartmentController {

    private DepartmentService service;

    public DepartmentController(DepartmentService service){
        this.service = service;
    }

    @GetMapping("/department")
    public ResponseEntity<Iterable<Department>> index(){
        return new ResponseEntity<>(service.index(), HttpStatus.OK);
    }

    @GetMapping("/department/{departmentNumber}")
    public ResponseEntity<Department> show(@PathVariable Long departmentNumber){
        return new ResponseEntity<>(service.show(departmentNumber),HttpStatus.OK);
    }

    @PostMapping("/department")
    public ResponseEntity<Department> create(Department department){
        return new ResponseEntity<>(service.create(department),HttpStatus.CREATED);
    }

    @PutMapping("/department/{departmentNumber}")
    public ResponseEntity<Department> update(@PathVariable Long departmentNumber, Department department) {
        return new ResponseEntity<>(service.update(departmentNumber, department), HttpStatus.OK);

    }

    @DeleteMapping("/department/{departmentNumber}")
    public ResponseEntity<Boolean> destroy(@PathVariable Long departmentNumber) {
        return new ResponseEntity<>(service.delete(departmentNumber), HttpStatus.OK);
    }


}
