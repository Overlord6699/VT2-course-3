package entity;

/**
 * Class that represents real laptop
 */
public class Laptop  extends Appliance{
    private String OS;
    private String CPU;
    private double battery;
    private int memory;
    private double display;

    public Laptop(String[] args) {
        super(Double.parseDouble(args[0]),args[1]);
        OS = args[2];
        CPU = args[3];
        battery = Double.parseDouble(args[4]);
        memory = Integer.parseInt(args[5]);
        display = Double.parseDouble(args[6]);
    }

    public double getBattery() {
        return battery;
    }
    public void setBattery(double battery) {
        this.battery = battery;
    }

    public String getOS() {
        return OS;
    }
    public void setOS(String OS) {
        this.OS = OS;
    }

    public int getMemory() {
        return memory;
    }
    public void setMemory(int memory) {
        this.memory = memory;
    }

    public String getCPU() {
        return CPU;
    }
    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public double getDisplay() {
        return display;
    }
    public void setDisplay(double display) {
        this.display = display;
    }

    @Override
    public String toString() {
        return "Laptop{" +
                "firm=" + firm +
                ", OS='" + OS + '\'' +
                ", CPU name='" + CPU + '\'' +
                " battery=" + battery +
                ", memory=" + memory +
                ", display=" + display +
                ", price=" + price +
                '}';
    }
}
