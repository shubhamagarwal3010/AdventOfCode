import Puzzle1.RocketFuelCalculation;

public class Main {

    public static void main(String[] args) {

        System.out.println("Total Fuel required on spacecraft: " + new RocketFuelCalculation().getTotalFuel());
        System.out.println("Total Fuel required on spacecraft including mass of fuel: " + new RocketFuelCalculation().getTotalFuelIncludingMassOfFuel());
    }
}
