package aircrafts.aircraftType.helicopters;

import aircrafts.aircraftType.PassengerAircraft;

/**
 * Created by OleksiiF on 26.01.2018.
 */
public class EurocopterEC135 extends PassengerAircraft{
    public EurocopterEC135(String model) {
        setName("Eurocopter EC135");
        setPassengerQuantity(6);
        setCargoVolumeInPassenger(1.1);
        setSerialNumber(model);
        setRange(635);
        setFuelCapacity(633);
        setFuelConsumption(240);
    }
}
