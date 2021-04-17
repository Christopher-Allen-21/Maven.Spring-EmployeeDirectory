package io.zipcoder.persistenceapp.Repositories;

import io.zipcoder.persistenceapp.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee,Long> {

}
