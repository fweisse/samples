package com.model;

import java.util.List;

public class Employee {

    private int id;
    private String name;
    private List<Employee> subordinates;

    public Employee(int id, String name, List<Employee> subordinates) {
        this.id = id;
        this.name = name;
        this.subordinates = subordinates;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Employee> getSubordinates() {
        return subordinates;
    }
}
