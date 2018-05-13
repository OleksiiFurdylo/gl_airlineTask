package com.aircrafts.aircraftType.planes.passangerAirplanes;

import com.aircrafts.aircraftType.planes.PassengerAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class AirbusA320 extends PassengerAirplane {
    public AirbusA320(String model) {
        setName("Airbus A320");
        setCargoVolumeInPassenger(37.4);
        setPassengerQuantity(180);

        setFuelCapacity(25300);
        setRange(6150);

        setSerialNumber(model);
        setFuelConsumption(2700);//l/h
    }



}
