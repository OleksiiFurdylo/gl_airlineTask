package com.aircrafts.aircraftType.planes.passangerAirplanes;

import com.aircrafts.aircraftType.planes.PassengerAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class AirbusA380 extends PassengerAirplane {
    public AirbusA380(String model) {
        setName("Airbus A380");
        setCargoVolumeInPassenger(184);
        setPassengerQuantity(544);
        setFuelCapacity(323000);
        setRange(15200);
        setSerialNumber(model);
        setFuelConsumption(12500);

    }
}
