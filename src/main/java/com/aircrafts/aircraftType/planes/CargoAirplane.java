package com.aircrafts.aircraftType.planes;

import com.aircrafts.Aircraft;
import com.aircrafts.aircraftType.Plane;
import com.templates.AircraftLoadTemplate;
import com.templates.TotalCapacityTemplate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by OleksiiF on 25.01.2018.
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class CargoAirplane extends Plane {

    private int maxLoadWeight;
    private double cargoVolumeInCargoAircraft;


    public CargoAirplane() {
        setType("Cargo Aircraft");
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public double getCargoVolumeInCargoAircraft() {
        return cargoVolumeInCargoAircraft;
    }

    public void setCargoVolumeInCargoAircraft(double cargoVolumeInCargoAircraft) {
        this.cargoVolumeInCargoAircraft = cargoVolumeInCargoAircraft;
    }


    @Override
    public TotalCapacityTemplate fillTotalCapacity(TotalCapacityTemplate totalCapacity, Aircraft aircraft) {
        totalCapacity.setTotalCargoVolumeInCargoA(totalCapacity.getTotalCargoVolumeInCargoA()
                +((CargoAirplane) aircraft).getCargoVolumeInCargoAircraft());

        totalCapacity.setTotalMaxLoadWeight(totalCapacity.getTotalMaxLoadWeight()
                +((CargoAirplane) aircraft).getMaxLoadWeight());

        totalCapacity.setTotalFuelCapacity(totalCapacity.getTotalFuelCapacity()+aircraft.getFuelCapacity());

        return totalCapacity;
    }

    @Override
    public AircraftLoadTemplate fillAircraftLoadFromAircraft(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        aircraftLoad.setMaxLoadWeight(((CargoAirplane)aircraft).getMaxLoadWeight());
        aircraftLoad.setCargoVolume(((CargoAirplane)aircraft).getCargoVolumeInCargoAircraft());

        return aircraftLoad;
    }

    @Override
    public Aircraft fillAircraftFromAircraftLoad(Aircraft aircraft, AircraftLoadTemplate aircraftLoad) {
        ((CargoAirplane)aircraft).setMaxLoadWeight(aircraftLoad.getMaxLoadWeight());
        ((CargoAirplane)aircraft).setCargoVolumeInCargoAircraft(aircraftLoad.getCargoVolume());

        return aircraft;
    }
}
