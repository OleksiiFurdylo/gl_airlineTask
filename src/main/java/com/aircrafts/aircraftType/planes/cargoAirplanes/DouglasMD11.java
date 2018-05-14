package com.aircrafts.aircraftType.planes.cargoAirplanes;

import com.aircrafts.aircraftType.planes.CargoAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class DouglasMD11 extends CargoAirplane {
    public DouglasMD11(String model, int companyId) {
        setName("McDonnell Douglas MD-11");
        setCargoVolumeInCargoAircraft(597);
        setMaxLoadWeight(168125);
        setFuelCapacity(146170);
        setRange(7320);
        setSerialNumber(model);
        setFuelConsumption(17150);
        setCompanyId(companyId);
    }
}
