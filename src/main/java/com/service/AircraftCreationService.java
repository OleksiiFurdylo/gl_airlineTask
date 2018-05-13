package com.service;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.planes.CargoAirplane;
import com.aircrafts.aircraftType.planes.PassengerAirplane;
import com.templates.AircraftLoadTemplate;
import org.springframework.stereotype.Service;

/**
 * Created by OleksiiF on 13.05.2018.
 */
@Service
public class AircraftCreationService {

    public Aircraft createPassengerAircraft(String name, String cargoVolume, String passengerQuantity,
                                            int fuelCapacity, int range, String serialNumber, int fuelConsumption,
                                            String loadWeight, int companyId){

        Aircraft aircraft = new PassengerAirplane();
        aircraft.setType("Passenger Aircraft");

        return fillAircraftDetails(name, cargoVolume, passengerQuantity, fuelCapacity, range, serialNumber,
                fuelConsumption, loadWeight, companyId, aircraft);
    }

    public Aircraft createCargoAircraft(String name, String cargoVolume, String passengerQuantity,
                                        int fuelCapacity, int range, String serialNumber, int fuelConsumption,
                                        String loadWeight, int companyId){

        Aircraft aircraft = new CargoAirplane();
        aircraft.setType("Cargo Aircraft");

        return fillAircraftDetails(name, cargoVolume, passengerQuantity, fuelCapacity, range, serialNumber,
                fuelConsumption, loadWeight, companyId, aircraft);
    }

    private Aircraft fillAircraftDetails(String name, String cargoVolume, String passengerQuantity,
                                        int fuelCapacity, int range, String serialNumber, int fuelConsumption,
                                        String loadWeight, int companyId, Aircraft aircraft){

        AircraftLoadTemplate aircraftLoad = new AircraftLoadTemplate();
        try {
            aircraftLoad.setPassengerQuantity(Integer.valueOf(passengerQuantity));
            aircraftLoad.setMaxLoadWeight(Integer.valueOf(loadWeight));
            aircraftLoad.setCargoVolume(Double.valueOf(cargoVolume));

        } catch (Exception e){
            e.getMessage();
        }

        aircraft.fillAircraftFromAircraftLoad(aircraft, aircraftLoad);

        aircraft.setCompanyId(companyId);
        aircraft.setSerialNumber(serialNumber);
        aircraft.setFuelCapacity(fuelCapacity);
        aircraft.setName(name);
        aircraft.setFuelConsumption(fuelConsumption);
        aircraft.setRange(range);

        return aircraft;
    }
}
