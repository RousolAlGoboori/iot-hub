package com.cs490.iothub.controller;

import com.cs490.iothub.model.DataItem;
import com.cs490.iothub.model.QueryStructure;
import com.cs490.iothub.model.Thing;
import com.cs490.iothub.model.VirtualSpace;
import com.cs490.iothub.service.CreateDataService;
import com.cs490.iothub.service.UIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:The controller class is responsible for processing
 * incoming REST API requests, preparing a model, and returning the view to be rendered as a response.
 * The controller classes in Spring are annotated either by the @Controller or the @RestController
 *  annotation. These mark controller classes as a request
 * handler to allow Spring to recognize it as a RESTful service during runtime.
*/
@RestController
public class DataController {

    @Autowired
    CreateDataService dataService;

    @Autowired
    UIService uiService;
    // Save thing
    @PostMapping("/create/thing")
    public Thing createThing(@RequestBody Thing thing) {
        return dataService.createThing(thing);
    }
    // Read things
    @GetMapping("/things")
    public List<Thing> getThings() {
        return dataService.getThings();
    }
    // Delete thing
    @DeleteMapping("/delete/thing/{thingId}")
    public String deleteThing(@PathVariable String thingId) {
        dataService.deleteThing(thingId);
        return thingId + " deleted successfully";
    }
    // Save dataItem
    @PostMapping("/create/dataItem")
    public DataItem createDataItem(@RequestBody DataItem dataItem) {
        return dataService.createDataItem(dataItem);
    }
    // Read dataItems
    @GetMapping("/dataItems")
    public List<DataItem> getDataItems() {
        return dataService.getDataItems();
    }
    // Delete dataItem
    @DeleteMapping("/delete/dataItem/{itemId}")
    public String deleteDataItem(@PathVariable String itemId) {
        dataService.deleteDataItem(itemId);
        return itemId + " deleted successfully";
    }
    // Read virtualSpaces
    @GetMapping("/virtualSpaces")
    public List<VirtualSpace> getVirtualSpaces() {
        return dataService.getVirtualSpaces();
    }

    // Delete virtualSpaces
    @DeleteMapping("/delete/virtualSpace/{virtualSpaceId}")
    public String deleteVirtualSpace(@PathVariable String virtualSpaceId) {
        dataService.deleteVirtualSpaces(virtualSpaceId);
        return virtualSpaceId + " deleted successfully";
    }
    // Save query
    @PostMapping(value = "/data/query")
    public Collection getQueryResults1(@RequestBody QueryStructure queryStructure) throws JsonProcessingException {
        Collection data = uiService.getQueryResult(queryStructure);
        return data;
    }
}
