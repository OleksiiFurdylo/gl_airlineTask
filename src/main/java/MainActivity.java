import com.companies.AircraftStoringCo;

import java.util.Scanner;

/**
 * Created by OleksiiF on 25.01.2018.
 */
public class MainActivity {

    public static void main(String[] args) throws Exception {

        AircraftStoringCo aircraftStoringCompany = new AircraftStoringCo();
        consoleMenu(aircraftStoringCompany);

    }

    public static void consoleMenu(AircraftStoringCo aircraftStoringCompany) throws Exception {
        Scanner in = new Scanner(System.in);
        int command = 1;

        System.out.println("AircraftStoringCo created");

        while (command > 0) {
            System.out.println("\nPress 1 to Calculate the total capacity and carrying capacity of all the aircraft in the airline.");
            System.out.println("Press 2 to Display the list of aircraft of the company sorted by flight range.");
            System.out.println("Press 3 to Find airplanes corresponding to a given range of fuel consumption parameters.");
            System.out.println("press 0 to exit");

            command = in.nextInt();

            switch(command) {
                case 1:
                    System.out.println(aircraftStoringCompany
                            .calculateTotalAndCarryingCapacity()
                            .getTotalPassengerQuantity() + " persons");
                    System.out.println(aircraftStoringCompany
                            .calculateTotalAndCarryingCapacity()
                            .getTotalCargoVolumeInPassanger()

                            + aircraftStoringCompany
                            .calculateTotalAndCarryingCapacity()
                            .getTotalCargoVolumeInCargoA() + " m3, or "

                            + aircraftStoringCompany
                            .calculateTotalAndCarryingCapacity()
                            .getTotalMaxLoadWeight()+ " kg");
                    break;
                case 2:
                    aircraftStoringCompany.sortAndShowAircraftsByRange();
                    break;
                case 3:
                    Scanner fuelC = new Scanner(System.in);

                    System.out.println("Give minimum fuel consumption in l/h(typical numbers are 116, 240, 2700, 6800, 12500, 13500, 17100): ");
                    int min = fuelC.nextInt();
                    System.out.println("Give maximum fuel consumption in l/h(typical numbers are 116, 240, 2700, 6800, 12500, 13500, 17100): ");
                    int max = fuelC.nextInt();

                    aircraftStoringCompany.findAircratfByFuelConsumption(min, max);
                    break;
            }
            System.out.println("Continue? (1/0)");
            command = in.nextInt();

        }

        System.out.println("Good by");

    }
}
