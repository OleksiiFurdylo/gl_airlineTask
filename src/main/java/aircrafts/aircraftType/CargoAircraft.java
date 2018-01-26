package aircrafts.aircraftType;

import aircrafts.Aircraft;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class CargoAircraft extends Aircraft {

    private int maxLoadWeight;
    private int cargoVolumeInCargoAircraft;


    public CargoAircraft() {
        setType("Cargo Aircraft");
    }

    public int getMaxLoadWeight() {
        return maxLoadWeight;
    }

    public void setMaxLoadWeight(int maxLoadWeight) {
        this.maxLoadWeight = maxLoadWeight;
    }

    public int getCargoVolumeInCargoAircraft() {
        return cargoVolumeInCargoAircraft;
    }

    public void setCargoVolumeInCargoAircraft(int cargoVolumeInCargoAircraft) {
        this.cargoVolumeInCargoAircraft = cargoVolumeInCargoAircraft;
    }


}
