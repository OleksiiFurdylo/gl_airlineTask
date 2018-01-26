package aircrafts.aircraftType;

import aircrafts.Aircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class PassengerAircraft extends Aircraft {
    public PassengerAircraft() {
        setType("Passenger Aircraft");
    }

    private int passengerQuantity;

    public double getCargoVolumeInPassenger() {
        return cargoVolumeInPassenger;
    }

    public void setCargoVolumeInPassenger(double cargoVolumeInPassenger) {
        this.cargoVolumeInPassenger = cargoVolumeInPassenger;
    }

    private double cargoVolumeInPassenger;

    public int getPassengerQuantity() {
        return passengerQuantity;
    }

    public void setPassengerQuantity(int passengerQuantity) {
        this.passengerQuantity = passengerQuantity;
    }
}
