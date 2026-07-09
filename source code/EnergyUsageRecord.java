import java.util.ArrayList;

public class EnergyUsageRecord {

    public void displayRecords(ArrayList<Appliance> applianceList) {

        // Header
        System.out.println("\n=================================================");
        System.out.println("              ENERGY USAGE RECORD");
        System.out.println("=================================================");

        // If no input
        if (applianceList.isEmpty()) {
            System.out.println("No appliances recorded yet.");
            return;
        }

        // Lists all of the appliances with their details and energy consumption
        for (int i = 0; i < applianceList.size(); i++) {

            Appliance app = applianceList.get(i);

            String type = (app instanceof CoolingAppliance) ? "Cooling" : "Light";

            
            System.out.println("Appliance #" + (i + 1));
            System.out.println("Type          : " + type);
            System.out.println("Name          : " + app.getName());
            System.out.println("Power Rating  : " + app.getPowerRating() + " W");
            System.out.println("Usage Hours   : " + app.getUsageHours() + " hours/day");
            System.out.printf("Energy Used   : %.2f kWh/day%n",
                    app.calculateEnergyConsumption());
            System.out.println("--------------------------------------");
        }
    }
}
