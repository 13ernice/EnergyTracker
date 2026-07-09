import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EnergyTrackerApp 
{
    public static void main(String[] args) 
    {
        // References all used classes and creates objects for them
        Scanner scanner = new Scanner(System.in);
        ArrayList<Appliance> applianceList = new ArrayList<>();
        ApplianceManager applianceManager = new ApplianceManager();
        EnergyUsageRecord recordGenerator = new EnergyUsageRecord();
        SummaryEnergyReport reportGenerator = new SummaryEnergyReport();
        EnergySavingTips tipsGenerator = new EnergySavingTips();
        
        boolean isRunning = true;
        
        System.out.println("=================================================");
        System.out.println("       Household Energy Consumption Tracker      ");
        System.out.println("================================================="); // Header
        
        while (isRunning) // Main loop - SELECTION
            {
            System.out.println("\n--- Main Menu ---");
            System.out.println("1. Add New Appliance");
            System.out.println("2. Energy Usage Record");
            System.out.println("3. Summary Report");
            System.out.println("4. Energy Saving Tips");
            System.out.println("5. Exit");
            System.out.print("Please enter your choice (1-5): ");
            
            int choice = -1;
            try 
            {
                choice = scanner.nextInt();
                scanner.nextLine(); 
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("❌ Invalid input. Please enter a number.");
                scanner.nextLine();
                continue;
            }

            switch (choice)
            {
                case 1:
                    applianceManager.addAppliance(applianceList, scanner);
                    break;

                case 2:
                    recordGenerator.displayRecords(applianceList);
                    break;

                case 3:
                    reportGenerator.generateReport(applianceList);
                    break;

                case 4:
                    tipsGenerator.displayTips();
                    break;

                case 5:
                    isRunning = false;
                    System.out.println("Thank you for using the Energy Tracker. Stay Green! 🌱");
                    break;

                default:
                    System.out.println("❌ Invalid selection. Please enter a number between 1 and 5.");
            }
        }
        scanner.close();
    }
}