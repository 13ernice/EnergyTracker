import java.util.ArrayList;
import java.util.Scanner;

public class ApplianceManager {
    public void addAppliance(ArrayList<Appliance> applianceList, Scanner scanner) {

        // Prompt user for appliance details
        System.out.println("\n--- Select Appliance Type ---");
                    System.out.println("1. Light Appliance");
                    System.out.println("2. Cooling Appliance");
                    System.out.print("Enter choice (1-2): ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();
                    
                    System.out.print("Enter appliance name (e.g., Bedroom Light, AC): ");
                    String name = scanner.nextLine();
                    
                    System.out.print("Enter power rating in Watts: ");
                    double power = scanner.nextDouble();
                    
                    System.out.print("Enter daily usage in hours: ");
                    double hours = scanner.nextDouble();
                    
                    // Create and add the appropriate appliance based on user choice
                    if (typeChoice == 1) 
                    {
                        LightAppliance newLight = new LightAppliance(name, power, hours);
                        applianceList.add(newLight);
                        System.out.println("✅ Light appliance added successfully.");
                    } 
                    else if (typeChoice == 2) 
                    {
                        System.out.print("Enter temperature setting (°C): ");
                        int temp = scanner.nextInt();
                        CoolingAppliance newCooling = new CoolingAppliance(name, power, hours, temp);
                        applianceList.add(newCooling);
                        System.out.println("✅ Cooling appliance added successfully.");
                    } 
                    else // Invalid choice
                    {
                        System.out.println("❌ Invalid appliance type selected.");
                    }
                    
                
                }                        
}
