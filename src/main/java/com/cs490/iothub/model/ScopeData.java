package com.cs490.iothub.model;

import java.util.List;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */

public class ScopeData {
    // data members of the class.
    private String symbol;
    private List<String> scopeValues;
    // Methods to get and set the ScopeData properties
    public ScopeData(String symbol, List<String> scopeValues) {
        this.symbol = symbol;
        this.scopeValues = scopeValues;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public List<String> getScopeValues() {
        return scopeValues;
    }

    public void setScopeValues(List<String> scopeValues) {
        this.scopeValues = scopeValues;
    }
}
