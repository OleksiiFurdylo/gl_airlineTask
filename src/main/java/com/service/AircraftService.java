package com.service;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
import com.dao.AircraftDao;
import com.dao.impl.AircraftDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 11.05.2018.
 */
@Service
public class AircraftService {

    @Autowired
    private AircraftDao aircraftDao;

    public String addAircraft(Aircraft aircraft){
        return "inserted successfully with id: " + aircraftDao.addAircraft(aircraft)+" (if 0 - unsuccessfully)";
    }

    public void deleteAircraft(int aircraftId){
        aircraftDao.deleteAircraft(aircraftId);
    }

    public void editAircraft(Aircraft aircraft){
        aircraftDao.editAircraft(aircraft);
    }

    public Aircraft getAircraft(int aircraftId){
        return aircraftDao.getAircraft(aircraftId);
    }

    public ArrayList<Aircraft> getAllAircrafts(){
        return aircraftDao.getAllAircrafts();
    }

    public ArrayList<Aircraft> findAircratfByFuelConsumption(int minCons, int maxCons) {
        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        for(Aircraft aircraft: aircraftDao.getAllAircrafts()){
            if(minCons <= aircraft.getFuelConsumption() && maxCons >= aircraft.getFuelConsumption()) {
                aircrafts.add(aircraft);
            }
        }
        return aircrafts;
    }

    public ArrayList<Aircraft> findAircraftWhithSpecifiedPassengerCapacityAndFlightRange
            (int minPassenger, int maxPassenger, int minRange, int maxRange){
        ArrayList<Aircraft> aircrafts = new ArrayList<>();

        for(Aircraft aircraft: getAllAircrafts()){
            if(minRange <= aircraft.getRange() && maxRange >= aircraft.getRange() && aircraft instanceof PassengerAirplane){
                if(minPassenger < ((PassengerAirplane) aircraft).getPassengerQuantity() &&
                        maxPassenger > ((PassengerAirplane) aircraft).getPassengerQuantity()){
                    aircrafts.add(aircraft);
                }
            }
        }

        return aircrafts;
    }



}
