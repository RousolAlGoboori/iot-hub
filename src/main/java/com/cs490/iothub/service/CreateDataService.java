package com.cs490.iothub.service;

import com.cs490.iothub.model.DataItem;
import com.cs490.iothub.model.Thing;
import com.cs490.iothub.model.VirtualSpace;
import com.cs490.iothub.repository.DataItemRepository;
import com.cs490.iothub.repository.ThingRepository;
import com.cs490.iothub.repository.VirtualSpaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:A class which implements the ProductService interface with @Service annotation
 *  and write the business logic to store, retrieve, delete and updates the product.
 */
public class CreateDataService {

    @Autowired
    ThingRepository thingRepository;

    @Autowired
    DataItemRepository dataItemRepository;

    @Autowired
    VirtualSpaceRepository virtualSpaceRepository;


    public Thing createThing(Thing thing) {
        Thing newThing = new Thing();
        try {
            newThing = thingRepository.save(thing);
        } catch (Exception e) {
            System.out.println("In DataService failed to create new Thing");
            e.printStackTrace();
        }
        System.out.println("new"+ newThing.getName());
        return newThing;
    }

    public void deleteThing(String thingId) {
        try {
            thingRepository.deleteById(thingId);
        } catch (Exception e) {
            System.out.println("In DataService Failed to delete a Thing");
            e.printStackTrace();
        }
    }
    public List<Thing> getThings() {
        List<Thing> things = new ArrayList<>();
        thingRepository.findAll().iterator().forEachRemaining(things::add);
        return things;
    }

    public DataItem createDataItem(DataItem dataItem) {

        DataItem newDataItem = new DataItem();
        try {
            newDataItem = dataItemRepository.save(dataItem);
        } catch (Exception e) {
            System.out.println("In DataService failed to create new dataItem");
            e.printStackTrace();
        }
        return newDataItem;
    }

    public void deleteDataItem(String itemId) {

        try {
            dataItemRepository.deleteById(itemId);
        } catch (Exception e) {
            System.out.println("In DataService Failed to delete a dataItem");
            e.printStackTrace();
        }
    }

    public List<DataItem> getDataItems() {

        List<DataItem> dataItems = new ArrayList<>();
        dataItemRepository.findAll().iterator().forEachRemaining(dataItems::add);
        return dataItems;
    }

    public List<VirtualSpace> getVirtualSpaces() {

        List<VirtualSpace> virtualSpaces = new ArrayList<>();
        virtualSpaceRepository.findAll().iterator().forEachRemaining(virtualSpaces::add);
        return virtualSpaces;
    }
    public void deleteVirtualSpaces(String virtualSpaceId) {

        try {
            virtualSpaceRepository.deleteById(virtualSpaceId);
        } catch (Exception e) {
            System.out.println("In DataService Failed to delete a Thing");
            e.printStackTrace();
        }
    }

}
