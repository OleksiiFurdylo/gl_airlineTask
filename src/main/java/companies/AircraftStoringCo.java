package companies;

import companies.impl.TotalCapacity;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public interface AircraftStoringCo {
    TotalCapacity calculateTotalAndCarryingCapacity() throws Exception;
    void sortAndShowAircraftsByRange();
    void findAircratfByFuelConsumption(int minCons, int maxCons);
}
