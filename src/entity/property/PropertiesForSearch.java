package entity.property;

/**
 * Class contains searching properties for each appliance
 */
public class PropertiesForSearch {
    public enum Appliance {
        FIRM, PRICE;
    }

    public enum Laptop{
        FIRM, OS, BATTERY, MEMORY, CPU_NAME, DISPLAY, PRICE
    }
    public enum Oven{
        FIRM, CONSUMPTION, WEIGHT, CAPACITY, HEIGHT, WIDTH, MAX_DEGREE, NUM_OF_BURNERS, PRICE
    }
    public enum Fridge {
        FIRM, CONSUMPTION, WEIGHT, CAPACITY, HEIGHT, WIDTH, PRICE
    }
    public enum Speakers{
        FIRM, CONSUMPTION, POWER, FREQUENCY, VOLUME, PRICE
    }
    public enum WashingMachine {
        FIRM, CONSUMPTION, POWER, WEIGHT, SPEED, NUM_OF_MODES, PRICE
    }
    public enum Kettle {
        FIRM, TYPE, COLOR, CAPACITY, PRICE
    }




    private PropertiesForSearch() {}
}
