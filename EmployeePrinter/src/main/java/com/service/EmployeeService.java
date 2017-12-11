package com.service;

import com.dao.EmployeeDao;
import com.json.PrintableEmployee;
import com.json.PrintableEmployees;
import com.model.Employee;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeService {

    private EmployeeDao dao;

    public EmployeeService(EmployeeDao dao) {
        this.dao = dao;
    }

    public PrintableEmployees getPrintablesEMployees() {
        PrintableEmployees employess = new PrintableEmployees();
        getAllEmployeesForPrint().forEach(em -> employess.addEmployee(em));
        return employess;
    }

    private List<PrintableEmployee> getAllEmployeesForPrint() {
        return dao.getAllEmployees().stream()
                .map(emp -> getRecordsFor(emp))
                .flatMap(printables -> printables.stream())
                .collect(Collectors.toList());
    }


    public List<PrintableEmployee> getRecordsFor(Employee employee) {
        List<PrintableEmployee> records = new LinkedList<>();
        getRecordsFor(employee, 0, records);
        return records;
    }


     // Keeps the tail recursion for simplicity, but this method recursion could be removed
    private void getRecordsFor(Employee employee, int acum, List<PrintableEmployee> records) {
        records.add(new PrintableEmployee(acum, employee.getName()));
        employee.getSubordinates()
                .forEach(sub -> getRecordsFor(sub, acum + 1 , records));

    }

}
