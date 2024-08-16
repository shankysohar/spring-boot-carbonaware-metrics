package com.snowfort.carbon.sci;

/**
 * This is the primary provider of computed Software Carbon Intensity score.
 */
public class SoftwareCarbonIntensity {

    private double energyConsumption;
    private double marginalEmissions;
    private double embodiedEmissions;

    public SoftwareCarbonIntensity(double energyConsumption, double marginalEmissions, double embodiedEmissions) {
        this.energyConsumption = energyConsumption;
        this.marginalEmissions = marginalEmissions;
        this.embodiedEmissions = embodiedEmissions;
    }

    public double getEnergyConsumption() {
        return energyConsumption;
    }

    public double getMarginalEmissions() {
        return marginalEmissions;
    }

    public double getEmbodiedEmissions() {
        return embodiedEmissions;
    }

    public double getSoftwareCarbonIntensity() {
        System.out.println("Energy Consumption is "+ energyConsumption)
        System.out.println("Marginal Consumption is "+ marginalEmissions)
        System.out.println("Embodied Consumption is "+ embodiedEmissions)

        return (energyConsumption * marginalEmissions) + embodiedEmissions;
    }

}
