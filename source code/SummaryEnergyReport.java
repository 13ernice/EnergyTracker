import java.util.ArrayList;

public class SummaryEnergyReport {

    private static final double COST_PER_KWH = 0.22;

    public void generateReport(ArrayList<Appliance> applianceList) {
        if (applianceList.isEmpty()) {
            System.out.println("⚠️ No appliances recorded. Cannot generate summary report.");
            return;
        }

        double totalEnergy = 0.0;
        Appliance highestAppliance = null;
        double maxEnergy = -1.0;

        for (Appliance app : applianceList) {
            double consumption = app.calculateEnergyConsumption();
            totalEnergy += consumption;
            if (consumption > maxEnergy) {
                maxEnergy = consumption;
                highestAppliance = app;
            }
        }

        double averageEnergy = totalEnergy / applianceList.size();
        double estimatedCost = totalEnergy * COST_PER_KWH;

        System.out.println("\n=================================================");
        System.out.println("            📊 SUMMARY ENERGY REPORT             ");
        System.out.println("=================================================");
        System.out.printf("Total Energy Used        : %.2f kWh/day\n", totalEnergy);
        System.out.printf("Average Usage per Device : %.2f kWh/day\n", averageEnergy);
        System.out.printf("Estimated Daily Cost     : RM %.2f\n", estimatedCost);
        System.out.println("-------------------------------------------------");
        
        if (highestAppliance != null) {
            System.out.println("🔥 HIGHEST ENERGY APPLIANCE:");
            System.out.printf("- Name: %s\n", highestAppliance.getName());
            System.out.printf("- Energy Used: %.2f kWh/day\n", maxEnergy);
        }
        System.out.println("=================================================");
    }
}

