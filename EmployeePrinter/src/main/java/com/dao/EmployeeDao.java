package com.dao;

import com.model.Employee;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class EmployeeDao {


    /*
    * Alan 100 150
Martin 220 100
Jamie 150
Alex 275 100
Steve 400 150
David 190 400
    * */

    public List<Employee> getAllEmployees () {


        Employee martin = new Employee(220, "Martin", Collections.emptyList());
        Employee alex = new Employee(275, "Alex", Collections.emptyList());
        Employee alan = new Employee(100, "Alan", new ListBuilder().add(martin).add(alex).build());
        Employee david = new Employee(190, "David", Collections.emptyList());
        Employee steve = new Employee(400, "Steve", new ListBuilder().add(david).build());
        Employee jamie = new Employee(150, "Jamie", new ListBuilder().add(alan).add(steve).build());



        return  new ListBuilder()
                .add(jamie)
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

