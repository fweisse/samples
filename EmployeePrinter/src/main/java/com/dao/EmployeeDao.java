package com.dao;

import com.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDao {


    public List<Employee> getAllEmployees () {

        Employee homer = new Employee(1, "Homer", Collections.emptyList());
        Employee lenny = new Employee(2, "Lenny", Collections.emptyList());
        Employee carl = new Employee(3, "Carl", new ListBuilder().add(homer).add(lenny).build());
        Employee barny = new Employee(4, "Barny", Collections.emptyList());
        Employee graymie = new Employee(5, "Graymie", Collections.singletonList(barny));
        Employee burns = new Employee(6, "Burns", new ListBuilder().add(carl).add(graymie).build());
        Employee Smitthers = new Employee(7, "Smitthers", Collections.emptyList());

        return  new ListBuilder()
                .add(burns)
                .add(Smitthers)
                .build();
    }


    class ListBuilder {
         private List<Employee> l = new ArrayList();

        public ListBuilder add(Employee emp) {
            l.add(emp);
            return this;
        }

        public List<Employee> build() {
            return l;
        }
    }

}

