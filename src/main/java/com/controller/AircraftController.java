package com.controller;

import com.aircrafts.Aircraft;
import com.service.AircraftCreationService;
import com.service.AircraftService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 11.05.2018.
 */
@Controller
@RequestMapping("/aircraft")
public class AircraftController {

    @Autowired
    AircraftService aircraftService;

    @Autowired
    AircraftCreationService aircraftCreationService;

    @RequestMapping(method = RequestMethod.GET)
    public @ResponseBody
    ArrayList<Aircraft> showAllAircrafts(){
        return aircraftService.getAllAircrafts();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public @ResponseBody
    Aircraft showAircraft(@PathVariable("id") int aircraftId) {
        return aircraftService.getAircraft(aircraftId);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView addAircraft(@RequestParam("name") String name,
                                    @RequestParam(value = "cargo_volume") String cargoVolume,
                                    @RequestParam(value = "passenger_quantity", required = false, defaultValue = "0") String passengerQuantity,
                                    @RequestParam("fuel_capacity") int fuelCapacity,
                                    @RequestParam("range") int range,
                                    @RequestParam("serial_number") String serialNumber,
                                    @RequestParam("fuel_consumption") int fuelConsumption,
                                    @RequestParam(value = "load_weight", required = false, defaultValue = "0") String loadWeight,
                                    @RequestParam("company_id") int companyId,
                                    @RequestParam(value = "passenger_aircraft", required = false) String passengerAircraft,
                                    @RequestParam(value = "cargo_aircraft", required = false) String cargoAircraft
                                    ) {
        String status;
        ModelAndView mv = new ModelAndView("hello");

        if(passengerAircraft!=null && cargoAircraft == null){
            status = aircraftService.addAircraft(
            aircraftCreationService.createPassengerAircraft(name, cargoVolume, passengerQuantity, fuelCapacity,
                    range, serialNumber, fuelConsumption, loadWeight, companyId));
        } else if (cargoAircraft!=null && passengerAircraft == null){
            status = aircraftService.addAircraft(
            aircraftCreationService.createCargoAircraft(name, cargoVolume, passengerQuantity, fuelCapacity,
                    range, serialNumber, fuelConsumption, loadWeight, companyId));
        } else {
            status = "you have to check only one aircraft type in checkbox!";
        }

        mv.addObject("add_status", "Status: " + status);

        return mv;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public @ResponseBody Aircraft editAircraft(@PathVariable("id") int id){
        Aircraft aircraft = aircraftService.getAircraft(id);
        aircraft.setName("changed Aircraft");
        aircraftService.editAircraft(aircraft);

        return aircraftService.getAircraft(id);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deleteAircraft(@PathVariable("id") int id){
        aircraftService.deleteAircraft(id);
    }

    @RequestMapping(value = "/fuel_match", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Aircraft> getAircraftsByFuelConsumptionMatch(@RequestParam("min") int min,
                                                                  @RequestParam("max") int max){
        return aircraftService.findAircratfByFuelConsumption(min, max);
    }

    @RequestMapping(value = "/passenger_range_match", method = RequestMethod.GET)
    public @ResponseBody ArrayList<Aircraft> getAircraftsByPassengerAndRangeMatch(@RequestParam("minP") int minP,
                                                                                  @RequestParam("maxP") int maxP,
                                                                                  @RequestParam("minR") int minR,
                                                                                  @RequestParam("maxR") int maxR){
        return aircraftService.findAircraftWhithSpecifiedPassengerCapacityAndFlightRange(minP, maxP, minR, maxR);
    }

}
