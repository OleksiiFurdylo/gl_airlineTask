package com.aircrafts.aircraftType.planes;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.Plane;
import com.companies.AircraftLoadTemplate;
import com.companies.TotalCapacityTemplate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by OleksiiF on 25.01.2018.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class PassengerAirplane extends Plane {
    public PassengerAirplane() {
        setType("Passenger Aircraft");
    }

    private int passengerQuantity;
    private double cargoVolumeInPassenger;

    public double getCargoVolumeInPassenger() {
        return cargoVolumeInPassenger;
    }

    public void setCargoVolumeInPassenger(double cargoVolumeInPassenger) {
        this.cargoVolumeInPassenger = cargoVolumeInPassenger;
    }

    public int getPassengerQuantity() {
        return passengerQuantity;
    }

    public void setPassengerQuantity(int passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }

    @Override
    public TotalCapacityTemplate fillTotalCapacity(TotalCapacityTemplate totalCapacity, Aircraft aircraft) {
        totalCapacity.setTotalPassengerQuantity(totalCapacity.getTotalPassengerQuantity()
                +((PassengerAirplane) aircraft).getPassengerQuantity());

        totalCapacity.setTotalCargoVolumeInPassanger(totalCapacity.getTotalCargoVolumeInPassanger()
                +((PassengerAirplane) aircraft).getCargoVolumeInPassenger());

        return totalCapacity;
    }

    @Override
    public AircraftLoadTemplate fillAircraftLoadFromAircraft(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        aircraftLoad.setPassengerQuantity(((PassengerAirplane)aircraft).getPassengerQuantity());
        aircraftLoad.setCargoVolume(((PassengerAirplane)aircraft).getCargoVolumeInPassenger());

        return aircraftLoad;
    }

    @Override
    public Aircraft fillAircraftFromAircraftLoad(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        ((PassengerAirplane)aircraft).setPassengerQuantity(aircraftLoad.getPassengerQuantity());
        ((PassengerAirplane)aircraft).setCargoVolumeInPassenger(aircraftLoad.getCargoVolume());

        return aircraft;
    }
}
