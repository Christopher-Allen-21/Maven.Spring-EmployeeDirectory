package io.zipcoder.persistenceapp.Models;

import javax.persistence.*;

@Entity
public class Department {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long id;
    private String departmentName;
    private Long departmentManagerId;


    public Department(){

    }

    public Department(String departmentName, Long departmentManagerId, Long id) {
        this.departmentName = departmentName;
        this.departmentManagerId = departmentManagerId;
        this.id = id;
    }

    public Long getDepartmentNumber() {
        return id;
    }

    public void setDepartmentNumber(Long departmentNumber) {
        this.id = departmentNumber;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public Long getDepartmentManagerId() {
        return departmentManagerId;
    }

    public void setDepartmentManagerId(Long departmentManagerId) {
        this.departmentManagerId = departmentManagerId;
    }

}
