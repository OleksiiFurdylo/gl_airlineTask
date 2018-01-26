package aircrafts.aircraftType.planes.passangerAirplanes;

import aircrafts.aircraftType.PassengerAircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class Boeing747 extends PassengerAircraft{
    public Boeing747(String model) {
        setName("Airbus A380");
        setCargoVolumeInPassenger(184);
        setPassengerQuantity(416);
        setFuelCapacity(240800);
        setRange(14450);
        setSerialNumber(model);
        setFuelConsumption(13500);
    }
}
