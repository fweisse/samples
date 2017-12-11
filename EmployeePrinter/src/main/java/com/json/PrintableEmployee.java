package com.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PrintableEmployee {

    int columnPos;
    String name;

    @JsonCreator
    public PrintableEmployee(@JsonProperty("column") int columnPos,
                             @JsonProperty("name") String name) {
        this.columnPos = columnPos;
        this.name = name;
    }

    public int getColumnPos() {
        return columnPos;
    }

    public String getName() {
        return name;
    }
}
