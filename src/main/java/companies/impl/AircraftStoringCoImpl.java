package companies.impl;

import aircrafts.Aircraft;
import aircrafts.aircraftType.CargoAircraft;
import aircrafts.aircraftType.PassengerAircraft;
import aircrafts.aircraftType.helicopters.EurocopterEC135;
import aircrafts.aircraftType.planes.cargoAirplanes.Boeing777;
import aircrafts.aircraftType.planes.cargoAirplanes.DouglasMD11;
import aircrafts.aircraftType.planes.passangerAirplanes.AirbusA320;
import aircrafts.aircraftType.planes.passangerAirplanes.AirbusA380;
import aircrafts.aircraftType.planes.passangerAirplanes.Boeing747;
import aircrafts.aircraftType.planes.passangerAirplanes.CitationJet;
import companies.AircraftStoringCo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class AircraftStoringCoImpl implements AircraftStoringCo{

    ArrayList<Aircraft> allAircraftsInCompany = new ArrayList<>();

    public AircraftStoringCoImpl() {
        allAircraftsInCompany.addAll(Arrays.asList(
                new AirbusA380("8960FB"),
                new Boeing777("CA0070"),
                new AirbusA320("MD5038"),
                new AirbusA380("3594NB"),
                new CitationJet("CJ0486"),
                new Boeing777("BE0456"),
                new Boeing747("BE9456"),
                new DouglasMD11("DU1305"),
                new EurocopterEC135("EC5830")));
    }
    public TotalCapacity calculateTotalAndCarryingCapacity() throws Exception {

        TotalCapacity totalCapacity = new TotalCapacity();

        for (Aircraft aircraft: allAircraftsInCompany) {

            if (aircraft instanceof PassengerAircraft) {
                totalCapacity.setTotalPassengerQuantity(totalCapacity.getTotalPassengerQuantity()
                        +((PassengerAircraft) aircraft).getPassengerQuantity());

                totalCapacity.setTotalCargoVolumeInPassanger(totalCapacity.getTotalCargoVolumeInPassanger()
                        +((PassengerAircraft) aircraft).getCargoVolumeInPassenger());

            }
            else if (aircraft instanceof CargoAircraft) {
                totalCapacity.setTotalCargoVolumeInCargoA(totalCapacity.getTotalCargoVolumeInCargoA()
                        +((CargoAircraft) aircraft).getCargoVolumeInCargoAircraft());

                totalCapacity.setTotalMaxLoadWeight(totalCapacity.getTotalMaxLoadWeight()
                        +((CargoAircraft) aircraft).getMaxLoadWeight());
            }
            else throw new Exception("object is not either instance of any AircraftType");

        }

        return totalCapacity;

    }

    public void sortAndShowAircraftsByRange() {
        allAircraftsInCompany.sort(Comparator.comparingInt(Aircraft::getRange));
        for(Aircraft aircraft: allAircraftsInCompany) {
            System.out.println(aircraft.getName()
                    + "("
                    + aircraft.getSerialNumber()
                    + ")"
                    + " with range "
                    + aircraft.getRange()
                    + " km" );
        }
    }

    public void findAircratfByFuelConsumption(int minCons, int maxCons) {


        for(Aircraft aircraft: allAircraftsInCompany){
            if(minCons <= aircraft.getFuelConsumption() && maxCons >= aircraft.getFuelConsumption()) {
                System.out.println(aircraft.getName()
                        + "("
                        + aircraft.getSerialNumber()
                        + ")"
                        + " with consumption of "
                        + aircraft.getFuelConsumption()
                        + " l/h");
            }
        }

    }
}

