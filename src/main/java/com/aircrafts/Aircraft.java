package com.aircrafts;

import com.companies.AircraftLoadTemplate;
import com.companies.TotalCapacityTemplate;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by OleksiiF on 25.01.2018.
 */
@XmlRootElement(name = "aircrafts")
@XmlAccessorType(XmlAccessType.FIELD)
public abstract class Aircraft {
    private String name;
    private String type;
    private int fuelCapacity;       //l
    private int range;              // km, typical payload
    private int fuelConsumption;    // l/h
    private String serialNumber;
    private int companyId;
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCompanyId() {
        return companyId;
    }

    public void setCompanyId(int companyId) {
        this.companyId = companyId;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public int getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(int fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getFuelConsumption() {
        return fuelConsumption;
    }

    public void setFuelConsumption(int fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }


    public abstract TotalCapacityTemplate fillTotalCapacity(TotalCapacityTemplate totalCapacity, Aircraft aircraft);
    public abstract AircraftLoadTemplate fillAircraftLoadFromAircraft(Aircraft aircraft, AircraftLoadTemplate aircraftLoad);
    public abstract Aircraft fillAircraftFromAircraftLoad(Aircraft aircraft, AircraftLoadTemplate aircraftLoad);
}
