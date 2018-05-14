package com.aircrafts.aircraftType.planes.cargoAirplanes;

import com.aircrafts.aircraftType.planes.CargoAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class Boeing777 extends CargoAirplane {
    public Boeing777(String model, int companyId) {
        setName("Boeing 777 Freighter");
        setCargoVolumeInCargoAircraft(636);
        setMaxLoadWeight(199000);
        setFuelCapacity(181435);
        setRange(9330);
        setSerialNumber(model);
        setFuelConsumption(6800);
        setCompanyId(companyId);
    }
}
