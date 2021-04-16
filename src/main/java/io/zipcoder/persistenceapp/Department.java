package io.zipcoder.persistenceapp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Department {

    private @Id @GeneratedValue(strategy = GenerationType.AUTO) Long departmentNumber;
    private String departmentName;
    private Employee departmentManager;

    public Department(){

    }

}
