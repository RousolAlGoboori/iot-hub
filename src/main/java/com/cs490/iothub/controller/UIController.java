package com.cs490.iothub.controller;

import com.cs490.iothub.model.*;
import com.cs490.iothub.service.CreateDataService;
import com.cs490.iothub.service.UIService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

import java.sql.SQLOutput;
import java.util.*;
/*
 * Author: Rousol Al Goboori
 * Semester: 05/2022
 * Class Description:The controller class is responsible for processing
 * incoming REST API requests, preparing a model, and returning the view to be rendered as a response.
 * The controller classes in Spring are annotated either by the @Controller or the @RestController
 *  annotation. These mark controller classes as a request
 * handler to allow Spring to recognize it as a RESTful service during runtime.
 */
@Controller
public class UIController {

    @Autowired
    UIService uiService;

    @Autowired
    CreateDataService createDataService;

    // Read operation
    @GetMapping(value = "/app")
    public String fetchThingsAndDataItems(Model model) {

        List<String> things = uiService.getThings();
        List<String> dataItems = uiService.getDataItems();
        model.addAttribute("things", things);
        model.addAttribute("dataItems", dataItems);
        return "app";
    }
    // Read operation
    @GetMapping(value = "/thingsAndItems")
    public String thingsAndDataItems(Model model,Thing thing) {
        List<String> things = uiService.getThings();
        List<String> dataItems = uiService.getDataItems();
        model.addAttribute("things", things);
        model.addAttribute("dataItems", dataItems);
        return "thingsAndItems";
    }
    // Read virtualSpace
    @GetMapping(value = "/virtualSpace")
    public String virtualSpace(Model model) {

        Set<String> thingsNames = uiService.getAvailableThingsNames();
        Set<String> dataItems = uiService.getAvailableDataItemsNames();
        List<String> vSpaces = uiService.getAllVirtualSpaces();

        model.addAttribute("things", thingsNames);
        model.addAttribute("dataItems", dataItems);
        model.addAttribute("virtualSpace", new VirtualSpace());
        model.addAttribute("vSpaces", vSpaces);
        return "virtualSpace";
    }
    // Save operation
    @PostMapping(value = "/create/virtualSpace")
    public String createVirtualSpace(VirtualSpace request, Model model) {
            List<String> vSpaces = uiService.createVirtualSpace(request);
            model.addAttribute("vSpaces", vSpaces);
        return "redirect:/virtualSpace";
    }
    // Read Thing
    @GetMapping(value = "/createThingsAndItems")
    public String createThingsAndItems(Model model) {
        return "createThingsAndItems";
    }
    // Save Thing
    @PostMapping(value = "/create/newThing")
    public String createThing(Thing thing, RedirectAttributes redirectAttributes) {

         String alarmFound = uiService.checkForMatchingAlarm("TH", thing.getName());
         String newThingFlashMessage = uiService.createThing(thing);
         if(alarmFound != null)
         redirectAttributes.addFlashAttribute("flashMessage", alarmFound);
        //redirectAttributes.addFlashAttribute("flashMessage", newThingFlashMessage);
        return "redirect:/createThingsAndItems";
    }
    // Save DatItem
    @PostMapping(value = "/create/newDataItem")
    public String createDatItem(DataItem dataItem, RedirectAttributes redirectAttributes) {
            String alarmFound = uiService.checkForMatchingAlarm("DT", dataItem.getName());
            String newDataItemFlashMessage = uiService.createDataItem(dataItem);
            if(alarmFound != null)
            redirectAttributes.addFlashAttribute("flashMessage", alarmFound);
            //redirectAttributes.addFlashAttribute("flashMessage", newThingFlashMessage);
            System.out.println(alarmFound);
            return "redirect:/createThingsAndItems";
    }

    @RequestMapping(value ="/viewThing/{thingId}")
    @ResponseBody
    public Thing viewPost(@PathVariable("thingId") String id, Model model) {
        Thing thing= uiService.getThingById(id);
        model.addAttribute("allThings", thing);
        return thing;
    }
    // Read applications
    @GetMapping(value = "/applications")
    public String applications() {
        return "applications";
    }
    // Save query
    @PostMapping(value = "/query")
    public String query(QueryStructure queryStructure, Model model) throws JsonProcessingException {

        Collection queryResult = uiService.getQueryResult(queryStructure);
        List<String> columns = uiService.getAllColumnNames();

            if(!Objects.equals(queryStructure.getReturnAttributes(), "")) {
                columns = Arrays.stream(queryStructure.getReturnAttributes().split(",")).toList();
            }
            List<String> results = uiService.resolveResult(queryResult, columns);

            System.out.println(results);
            model.addAttribute("columns", columns);
            model.addAttribute("results", results);
        return "applications";
    }
    // Read asynchronousQuery
    @GetMapping(value = "/asynchronousQuery")
    public String asynchronousQuery() {
        return "asynchronousQuery";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String createAlarm(RedirectAttributes redirectAttributes, @ModelAttribute Alarm request) {
        List<Alarm> alarms = uiService.createAlarm(request);
        String message = "Available Alarms" + alarms + " ✨.";
        redirectAttributes.addFlashAttribute("userMessage", message);
        return "redirect:/asynchronousQuery";

    }
}
