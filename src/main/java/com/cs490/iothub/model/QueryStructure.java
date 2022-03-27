package com.cs490.iothub.model;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */
public class QueryStructure {
    // data members of the class.
    private String scope;
    private String returnAttributes;
    private String conditions;
    // Methods to get and set the queryStructure properties
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getReturnAttributes() {
        return returnAttributes;
    }

    public void setReturnAttributes(String returnAttributes) {
        this.returnAttributes = returnAttributes;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }
}
