package com.service;

import com.aircrafts.Aircraft;
import com.dao.AircraftDao;
import com.templates.TotalCapacityTemplate;
import com.dao.impl.AircraftDaoImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;

/**
 * Created by OleksiiF on 11.05.2018.
 */
@Service
public class AirlineService {

    @Autowired
    private AircraftDao aircraftDao;

    public ArrayList<Aircraft> getAllAircraftsInCompany(int companyId){
        return aircraftDao.getAllAircraftsInCompany(companyId);
    }

    public TotalCapacityTemplate calculateTotalAndCarryingCapacity(int companyId) {
        TotalCapacityTemplate totalCapacity = new TotalCapacityTemplate();

        for (Aircraft aircraft: aircraftDao.getAllAircraftsInCompany(companyId)) {
            aircraft.fillTotalCapacity(totalCapacity, aircraft);
        }

        return totalCapacity;
    }

    public ArrayList<Aircraft> sortAircraftsByRange(int companyId) {
        ArrayList<Aircraft> aircrafts = getAllAircraftsInCompany(companyId);
        aircrafts.sort(Comparator.comparingInt(Aircraft::getRange));

        return aircrafts;
    }
}
