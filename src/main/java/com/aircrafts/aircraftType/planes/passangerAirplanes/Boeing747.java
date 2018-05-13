package com.aircrafts.aircraftType.planes.passangerAirplanes;

import com.aircrafts.aircraftType.planes.PassengerAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class Boeing747 extends PassengerAirplane {
    public Boeing747(String model) {
        setName("Boeing 747-8");
        setCargoVolumeInPassenger(184);
        setPassengerQuantity(416);
        setFuelCapacity(240800);
        setRange(14450);
        setSerialNumber(model);
        setFuelConsumption(13500);
    }
}
