package entity;

/**
 * Class that represents real speakers
 */
public class Speakers extends Appliance {
    private double consumption;
    private int power;
    private double volume;
    private int frequency;

    public Speakers(String[] args) {
        super(Double.parseDouble(args[0]),args[1]);
        consumption = Double.parseDouble(args[2]);
        power = Integer.parseInt(args[3]);
        frequency = Integer.parseInt(args[4]);
        volume = Double.parseDouble(args[5]);
    }

    public double getConsumption() {
        return consumption;
    }
    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public int getPower() {
        return power;
    }
    public void setPower(int power) {
        this.power = power;
    }

    public int getFrequency() {
        return frequency;
    }
    public void setFrequency(int frequency) {
        this.frequency = frequency;
    }

    public double getVolume() {
        return volume;
    }
    public void setVolume(double volume) {
        this.volume = volume;
    }

    @Override
    public String toString() {
        return "Speakers{" +
                "firm=" + firm +
                " consumption=" + consumption +
                ", power=" + power +
                ", frequency='" + frequency + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                '}';
    }
}
