package io.zipcoder.persistenceapp;

import javax.persistence.*;

@Entity
public class Department {

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

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long departmentNumber;
    private String departmentName;
    @OneToOne
    private Employee departmentManager;

    public Department(){

    }

}
