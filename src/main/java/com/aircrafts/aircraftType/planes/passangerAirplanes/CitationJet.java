package com.aircrafts.aircraftType.planes.passangerAirplanes;

import com.aircrafts.aircraftType.planes.PassengerAirplane;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class CitationJet extends PassengerAirplane {
    public CitationJet(String model, int companyId) {
        setName("Cessna CitationJet");
        setPassengerQuantity(9);
        setCargoVolumeInPassenger(10);
        setRange(4100);
        setFuelCapacity(1783);
        setSerialNumber(model);
        setFuelConsumption(116);
        setCompanyId(companyId);


    }
}
