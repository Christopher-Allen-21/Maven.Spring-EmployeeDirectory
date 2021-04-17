package io.zipcoder.persistenceapp.Services;

import io.zipcoder.persistenceapp.Models.Department;
import io.zipcoder.persistenceapp.Models.Employee;
import io.zipcoder.persistenceapp.Repositories.DepartmentRepository;
import io.zipcoder.persistenceapp.Repositories.EmployeeRepository;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {

    private DepartmentRepository repository;

    public DepartmentService(DepartmentRepository departmentRepository){
        this.repository = departmentRepository;
    }

    public Iterable<Department> index(){
        return repository.findAll();
    }

    public Department show(Long departmentNumber){
        return repository.findOne(departmentNumber);
    }

    public Department create(Department department){
        return repository.save(department);
    }

    public Department update(Long id,Department department){
        Department originalDepartment = repository.findOne(id);
        originalDepartment.setDepartmentNumber(department.getDepartmentNumber());
        originalDepartment.setDepartmentName(department.getDepartmentName());
        originalDepartment.setDepartmentManager(department.getDepartmentManager());
        return repository.save(originalDepartment);
    }

    public Boolean delete(Long departmentNumber){
        repository.delete(departmentNumber);
        return true;
    }
}
