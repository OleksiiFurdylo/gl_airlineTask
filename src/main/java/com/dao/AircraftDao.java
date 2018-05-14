package com.dao;

import com.aircrafts.Aircraft;

import java.util.ArrayList;

/**
 * Created by OleksiiF on 10.05.2018.
 */
public interface AircraftDao {

    int addAircraft(Aircraft aircraft);
    void deleteAircraft(int id);
    void editAircraft(Aircraft aircraft);
    Aircraft getAircraft(int id);
    Aircraft getAircraft(String serialNumber);
    ArrayList<Aircraft> getAllAircrafts();
    ArrayList<Aircraft> getAllAircraftsInCompany(int companyId);

}
