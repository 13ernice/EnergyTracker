public class CoolingAppliance extends Appliance{

    public CoolingAppliance(String name, double powerRating, double usageHours, int temperatureSetting){
        super(name, powerRating, usageHours);
    }

    @Override
    // replace parent class version
    public double calculateEnergyConsumption(){
        double baseConsumption = super.calculateEnergyConsumption();
        if (baseConsumption > 8.0){
            return baseConsumption * 1.15;
            // 15% energy penalty
        }
        return baseConsumption;
    }
}