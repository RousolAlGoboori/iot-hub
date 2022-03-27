package com.cs490.iothub.model;

import com.cs490.iothub.annotation.DateField;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "dataItem")
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description: Defines a collection of state variables, as well as the
 * functionality for working with these variables.
 */
public class DataItem {

    // data members of the class.
    @Id
    String itemId;
    String name;
    String creator;
    List<String> access;
    String vSpaceDataItem;
    List<String> modifiersD,requesterD,subscriberD;
    @DateField
    Instant createdAtD,modifiedBD;
    String accessFrequencyD;
    String modificationFrequencyD;
    @DateField
    Instant expired;
    String format,typeDomain,applicationDomain, payload, accumulatedPayload;

    // Methods to get and set the dataItem properties
    public Instant getExpired() {
        return expired;
    }

    public void setExpired(Instant expired) {
        this.expired = expired;
    }

    public String getvSpaceDataItem() {
        return vSpaceDataItem;
    }

    public void setvSpaceDataItem(String vSpaceDataItem) {
        this.vSpaceDataItem = vSpaceDataItem;
    }

    public List<String> getModifiersD() {
        return modifiersD;
    }

    public void setModifiersD(List<String> modifiersD) {
        this.modifiersD = modifiersD;
    }

    public List<String> getRequesterD() {
        return requesterD;
    }

    public void setRequesterD(List<String> requesterD) {
        this.requesterD = requesterD;
    }

    public List<String> getSubscriberD() {
        return subscriberD;
    }

    public void setSubscriberD(List<String> subscriberD) {
        this.subscriberD = subscriberD;
    }

    public Instant getCreatedAtD() {
        return createdAtD;
    }

    public void setCreatedAtD(Instant createdAtD) {
        this.createdAtD = createdAtD;
    }

    public Instant getModifiedBD() {
        return modifiedBD;
    }

    public void setModifiedBD(Instant modifiedBD) {
        this.modifiedBD = modifiedBD;
    }

    public String getAccessFrequencyD() {
        return accessFrequencyD;
    }

    public void setAccessFrequencyD(String accessFrequencyD) {
        this.accessFrequencyD = accessFrequencyD;
    }

    public String getModificationFrequencyD() {
        return modificationFrequencyD;
    }

    public void setModificationFrequencyD(String modificationFrequencyD) {
        this.modificationFrequencyD = modificationFrequencyD;
    }



    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }

    public String getTypeDomain() {
        return typeDomain;
    }

    public void setTypeDomain(String typeDomain) {
        this.typeDomain = typeDomain;
    }

    public String getApplicationDomain() {
        return applicationDomain;
    }

    public void setApplicationDomain(String applicationDomain) {
        this.applicationDomain = applicationDomain;
    }

    public String getPayload() {
        return payload;
    }

    public void setPayload(String payload) {
        this.payload = payload;
    }

    public String getAccumulatedPayload() {
        return accumulatedPayload;
    }

    public void setAccumulatedPayload(String accumulatedPayload) {
        this.accumulatedPayload = accumulatedPayload;
    }

    public String getItemId() {
        return itemId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getAccess() {
        return access;
    }

    public void setAccess(List<String> access) {
        this.access = access;
    }
}
