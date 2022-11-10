package entity;

/**
 * Class that represents real washing machine
 */
public class WashingMachine extends Appliance{
    private double consumption;
    private int power;
    private double weight;
    private int speed;
    private int numOfModes;

    public WashingMachine(String[] args) {
        super(Double.parseDouble(args[0]),args[1]);
        consumption = Double.parseDouble(args[2]);
        power = Integer.parseInt(args[3]);
        weight = Double.parseDouble(args[4]);
        speed = Integer.parseInt(args[5]);
        numOfModes =Integer.parseInt(args[6]);
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

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getSpeed(){return speed;}
    public void setSpeed(int weight) {
        this.speed = speed;
    }

    public int getNumOfModes() { return numOfModes; }
    public void setNumOfModes(int numOfModes) { this.numOfModes = numOfModes; }

    @Override
    public String toString() {
        return "Washing machine{" +
                "firm='" + firm  +
                ", сonsumption=" + consumption +
                ", power=" + power +
                ", weight=" + weight +
                ", speed=" + speed +
                ", numOfModes=" + numOfModes +
                ", price=" + price +
                '}';
    }
}
