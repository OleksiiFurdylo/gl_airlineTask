package aircrafts.aircraftType.planes.passangerAirplanes;

import aircrafts.aircraftType.PassengerAircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class AirbusA380 extends PassengerAircraft{
    public AirbusA380(String model) {
        setName("Boeing 747-8");
        setCargoVolumeInPassenger(184);
        setPassengerQuantity(544);
        setFuelCapacity(323000);
        setRange(15200);
        setSerialNumber(model);
        setFuelConsumption(12500);

    }
}
