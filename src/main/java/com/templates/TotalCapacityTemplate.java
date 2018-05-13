package com.templates;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class TotalCapacityTemplate {
    private double totalFuelCapacity;
    private double totalCargoVolumeInPassanger;
    private int totalPassengerQuantity;
    private double totalCargoVolumeInCargoA;
    private int totalMaxLoadWeight;

    public double getTotalFuelCapacity() {
        return totalFuelCapacity;
    }

    public void setTotalFuelCapacity(double totalFuelCapacity) {
        this.totalFuelCapacity = totalFuelCapacity;
    }

    public double getTotalCargoVolumeInPassanger() {
        return totalCargoVolumeInPassanger;
    }

    public void setTotalCargoVolumeInPassanger(double totalCargoVolumeInPassanger) {
        this.totalCargoVolumeInPassanger = totalCargoVolumeInPassanger;
    }

    public int getTotalPassengerQuantity() {
        return totalPassengerQuantity;
    }

    public void setTotalPassengerQuantity(int totalPassengerQuantity) {
        this.totalPassengerQuantity = totalPassengerQuantity;
    }

    public double getTotalCargoVolumeInCargoA() {
        return totalCargoVolumeInCargoA;
    }

    public void setTotalCargoVolumeInCargoA(double totalCargoVolumeInCargoA) {
        this.totalCargoVolumeInCargoA = totalCargoVolumeInCargoA;
    }

    public int getTotalMaxLoadWeight() {
        return totalMaxLoadWeight;
    }

    public void setTotalMaxLoadWeight(int totalMaxLoadWeight) {
        this.totalMaxLoadWeight = totalMaxLoadWeight;
    }
}
