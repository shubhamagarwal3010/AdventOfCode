import puzzle1.RocketFuelCalculation;
import puzzle2.GravityAssistProgram;

public class Main {

    public static void main(String[] args) {

        System.out.println("Total Fuel required on spacecraft: " + new RocketFuelCalculation().getTotalFuel());
        System.out.println("Total Fuel required on spacecraft including mass of fuel: " + new RocketFuelCalculation().getTotalFuelIncludingMassOfFuel());
        System.out.println("Gravity assist program result for fixed correction value: " + new GravityAssistProgram().getResultWithCorrectionData(12, 2));
        System.out.println("Gravity assist program noun verb result: " + new GravityAssistProgram().getNounVerbResultWhichProducesOutput(19690720));
    }
}
