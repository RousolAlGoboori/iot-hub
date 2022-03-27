package com.cs490.iothub.model;

/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */

public class Condition {

    // data members of the class.
    private String columnName;
    private String operator;
    private String value;

    // Constructor would initialize data members
    // With the values of passed arguments while
    // Object of that class created
    public Condition(String columnName, String operator, String value) {
        this.columnName = columnName;
        this.operator = operator;
        this.value = value;
    }
    // Methods to get and set the Condition properties
    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
