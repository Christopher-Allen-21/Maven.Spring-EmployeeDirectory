package io.zipcoder.persistenceapp.Models;

import javax.persistence.*;

@Entity
public class Department {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long departmentNumber;
    private String departmentName;
    @OneToOne
    private Employee departmentManager;


    public Department(){

    }

    public Department(String departmentName, Employee departmentManager) {
        this.departmentName = departmentName;
        this.departmentManager = departmentManager;
    }

    public Long getDepartmentNumber() {
        return departmentNumber;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.departmentNumber = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Employee getDepartmentManager() {
        return departmentManager;
    }

    public void setDepartmentManager(Employee departmentManager) {
        this.departmentManager = departmentManager;
    }

}
