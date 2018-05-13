package com.aircrafts.aircraftType.helicopters;

import com.aircrafts.Aircraft;
import com.templates.AircraftLoadTemplate;
import com.templates.TotalCapacityTemplate;

/**
 * Created by OleksiiF on 26.01.2018.
 */
public class EurocopterEC135 extends Aircraft{
    public EurocopterEC135(String model) {
        setName("Eurocopter EC135");
        //setPassengerQuantity(6);
        //setCargoVolumeInPassenger(1.1);
        setSerialNumber(model);
        setRange(635);
        setFuelCapacity(633);
        setFuelConsumption(240);
    }

    @Override
    public TotalCapacityTemplate fillTotalCapacity(TotalCapacityTemplate totalCapacity, Aircraft aircraft) {
        return null;
    }

    @Override
    public AircraftLoadTemplate fillAircraftLoadFromAircraft(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        return null;
    }

    @Override
    public Aircraft fillAircraftFromAircraftLoad(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        return null;
    }
}
