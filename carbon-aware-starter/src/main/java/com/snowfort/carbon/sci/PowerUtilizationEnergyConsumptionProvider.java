package com.snowfort.carbon.sci;

import oshi.SystemInfo;
import oshi.hardware.HardwareAbstractionLayer;

public class PowerUtilizationEnergyConsumptionProvider implements EnergyConsumptionProvider {
    /**
     * This calculates the power usage in kW.
     * While charging the power usage rate is positive otherwise
     * it negative so its absolute value is considered.
     * It gives the reading in mW, hence divided it by 10e-6
     *
     * @return the energy consumption
     */
    @Override
    public double getEnergyConsumption() {
        SystemInfo si = new SystemInfo();
        HardwareAbstractionLayer hal = si.getHardware();

        return hal.getPowerSources()
                .stream()
                .mapToDouble(ps -> {
                    double usageRate = Math.abs(ps.getPowerUsageRate()) ;
                    System.out.println("Power usage rate : " + usageRate);
                    return usageRate / 1000000;
                })
                .average()
                .orElse(0.0);    }
}
