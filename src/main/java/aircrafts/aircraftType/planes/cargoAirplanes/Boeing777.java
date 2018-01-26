package aircrafts.aircraftType.planes.cargoAirplanes;

import aircrafts.aircraftType.CargoAircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class Boeing777 extends CargoAircraft{
    public Boeing777(String model) {
        setName("Boeing 777 Freighter");
        setCargoVolumeInCargoAircraft(636);
        setMaxLoadWeight(199000);
        setFuelCapacity(181435);
        setRange(9330);
        setSerialNumber(model);
        setFuelConsumption(6800);
    }
}
