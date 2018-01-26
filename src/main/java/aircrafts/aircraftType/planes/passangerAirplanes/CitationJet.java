package aircrafts.aircraftType.planes.passangerAirplanes;

import aircrafts.aircraftType.PassengerAircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class CitationJet extends PassengerAircraft {
    public CitationJet(String model) {
        setName("Cessna CitationJet");
        setPassengerQuantity(9);
        setCargoVolumeInPassenger(10);
        setRange(4100);
        setFuelCapacity(1783);
        setSerialNumber(model);
        setFuelConsumption(116);


    }
}
