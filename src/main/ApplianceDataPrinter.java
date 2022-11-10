package main;

import entity.Appliance;

import java.util.List;

public class ApplianceDataPrinter {

    /**
     * Overloaded method for printing list of appliances data
     * @param appliances - found appliances
     */
    public static void print(List<Appliance> appliances) {
        if (appliances == null) {
            System.out.println("ERROR!Wrong search properties");
            return;
        }
        if (appliances.isEmpty()) {
            System.out.println("Appliance was not found");
            return;
        }

        for (Appliance appliance : appliances) {
            System.out.println(appliance);
        }
    }

    /**
     * Overloaded method for printing one appliance data
     * @param appliance - found appliance
     */
    public static void print(Appliance appliance) {
        if (appliance == null) {
            System.out.println("Appliance was not found");
            return;
        }

        System.out.println(appliance);
    }
}
