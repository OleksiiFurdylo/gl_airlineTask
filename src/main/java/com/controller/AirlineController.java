package com.controller;

import com.aircrafts.Aircraft;
import com.templates.TotalCapacityTemplate;
import com.service.AirlineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 13.05.2018.
 */
@Controller
@RequestMapping("/airline")
public class AirlineController {

    @Autowired
    private AirlineService airlineService;

    @RequestMapping(value = "/{id}/capacity", method = RequestMethod.GET)
    public @ResponseBody
    TotalCapacityTemplate calculateCapacityOfCompany(@PathVariable("id") int id){
        return airlineService.calculateTotalAndCarryingCapacity(id);
    }

    @RequestMapping(value = "/{id}/sorted", method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Aircraft> getSortedListOfAircraftsInCompany(@PathVariable("id") int id){
        return airlineService.sortAircraftsByRange(id);
    }
}
