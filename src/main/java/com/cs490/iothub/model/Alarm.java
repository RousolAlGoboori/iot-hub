package com.cs490.iothub.model;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
*/
public class Alarm {

    // data members of the class.
    private String scope;
    private String conditions;

    // Methods to get and set the alarm properties
    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    @Override
    public String toString() {
        return
                "(scope='" + scope + '\'' +
                ", conditions='" + conditions + '\'' +") \n"
                ;
    }
}
