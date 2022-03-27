package com.cs490.iothub.model;

import com.cs490.iothub.annotation.DateField;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "thing")

/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */
public class Thing {

    // data members of the class.
    @Id
    String thingId;
    String name;
    String IPAddress;
    @DateField
    Instant active;
    String  vSpacesThing;
    List<String> createdT,modifiedT, requestedT, subscribedT;

    // Methods to get and set the thing properties
    public String getvSpacesThing() {
        return vSpacesThing;
    }

    public void setvSpacesThing(String vSpacesThing) {
        this.vSpacesThing = vSpacesThing;
    }

    public List<String> getCreatedT() {
        return createdT;
    }

    public void setCreatedT(List<String> createdT) {
        this.createdT = createdT;
    }

    public List<String> getModifiedT() {
        return modifiedT;
    }

    public void setModifiedT(List<String> modifiedT) {
        this.modifiedT = modifiedT;
    }

    public List<String> getRequestedT() {
        return requestedT;
    }

    public void setRequestedT(List<String> requestedT) {
        this.requestedT = requestedT;
    }

    public List<String> getSubscribedT() {
        return subscribedT;
    }

    public void setSubscribedT(List<String> subscribedT) {
        this.subscribedT = subscribedT;
    }

    public String getThingId() {
        return thingId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public void setIPAddress(String IPAddress) {
        this.IPAddress = IPAddress;
    }

    public Instant getActive() {
        return active;
    }

    public void setActive(Instant active) {
        this.active = active;
    }

}
