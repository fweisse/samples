package com.json;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.LinkedList;
import java.util.List;


public class PrintableEmployees {

    @JsonProperty("columnCount")
    private int columnCount;
    @JsonProperty("employess")
    private List<PrintableEmployee> employess;

    public PrintableEmployees addEmployee(PrintableEmployee employee) {
        if (this.employess == null) {
            this.employess = new LinkedList<>();
        }
        this.employess.add(employee);
        columnCount = Math.max(columnCount, employee.columnPos +1);
        return this;
    }

    public int getColumnCount() {
        return columnCount;
    }

    public List<PrintableEmployee> getEmployess() {
        return employess;
    }
}
