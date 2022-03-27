package com.cs490.iothub.model;

import com.cs490.iothub.annotation.DateField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "virtualSpace")
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */
public class VirtualSpace {
    // data members of the class.
    @Id
    String virtualSpaceId;
    String description;
    String type;
    String[] selectedThings;
    String[] selectedDataItems;
    @DateField
    Instant createdAt;
    // Methods to get and set the ScopeData properties
    public String getVirtualSpaceId() {
        return virtualSpaceId;
    }

    public void setVirtualSpaceId(String virtualSpaceId) {
        this.virtualSpaceId = virtualSpaceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String[] getSelectedThings() {
        return selectedThings;
    }

    public void setSelectedThings(String[] selectedThings) {
        this.selectedThings = selectedThings;
    }

    public String[] getSelectedDataItems() {
        return selectedDataItems;
    }

    public void setSelectedDataItems(String[] selectedDataItems) {
        this.selectedDataItems = selectedDataItems;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }
}
