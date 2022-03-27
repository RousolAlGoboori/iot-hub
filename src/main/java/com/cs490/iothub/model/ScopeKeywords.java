package com.cs490.iothub.model;

import java.util.Arrays;
import java.util.stream.Collectors;

/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: An enum is a special "class"
 * that represents a group of constants (unchangeable variables, like final variables).
 */
public enum ScopeKeywords {
    TH("thing"),
    DT("dataItem"),
    VS("virtualSpace");

    private String tableName;

    // Constructor
    ScopeKeywords(String tableName) {
        this.tableName = tableName;
    }

    public String getTableName() {
        return this.tableName;
    }

    public static String fromString(String text) {
        for (ScopeKeywords b : ScopeKeywords.values()) {
            if (b.toString().equals(text)) {
                return b.tableName;
            }
        }
        return null;
    }

}
