package com.companies;

import com.aircrafts.aircraftType.helicopters.EurocopterEC135;
import com.aircrafts.aircraftType.planes.cargoAirplanes.Boeing777;
import com.aircrafts.aircraftType.planes.passangerAirplanes.AirbusA320;
import com.aircrafts.aircraftType.planes.passangerAirplanes.AirbusA380;
import com.aircrafts.aircraftType.planes.passangerAirplanes.Boeing747;
import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.cargoAirplanes.DouglasMD11;
import com.aircrafts.aircraftType.planes.passangerAirplanes.CitationJet;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class AircraftStoringCo{

    ArrayList<Aircraft> allAircraftsInCompany = new ArrayList<>();

    public AircraftStoringCo() {
        allAircraftsInCompany.addAll(Arrays.asList(
                new AirbusA380("8960FB"),
                new Boeing777("CA0070"),
                new AirbusA320("MD5038"),
                new AirbusA380("3594NB"),
                new CitationJet("CJ0486"),
                new Boeing777("BE0456"),
                new Boeing747("BE9456"),
                new DouglasMD11("DU1305"),
                new EurocopterEC135("EC5830")));
    }
    public TotalCapacityTemplate calculateTotalAndCarryingCapacity() throws Exception {
        TotalCapacityTemplate totalCapacity = new TotalCapacityTemplate();

        for (Aircraft aircraft: allAircraftsInCompany) {
            aircraft.fillTotalCapacity(totalCapacity, aircraft);
        }

        return totalCapacity;

    }

    public void sortAndShowAircraftsByRange() {
        allAircraftsInCompany.sort(Comparator.comparingInt(Aircraft::getRange));
        for(Aircraft aircraft: allAircraftsInCompany) {
            System.out.println(aircraft.getName()
                    + "("
                    + aircraft.getSerialNumber()
                    + ")"
                    + " with range "
                    + aircraft.getRange()
                    + " km" );
        }
    }

    public void findAircratfByFuelConsumption(int minCons, int maxCons) {


        for(Aircraft aircraft: allAircraftsInCompany){
            if(minCons <= aircraft.getFuelConsumption() && maxCons >= aircraft.getFuelConsumption()) {
                System.out.println(aircraft.getName()
                        + "("
                        + aircraft.getSerialNumber()
                        + ")"
                        + " with consumption of "
                        + aircraft.getFuelConsumption()
                        + " l/h");
            }
        }

    }
}

