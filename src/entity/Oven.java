package entity;

/**
 * Class that represents real oven
 */
public class Oven extends Appliance{
    private double consumption;
    private double capacity;
    private double weight;
    private double height;
    private double width;
    private int maxDegree;
    private int numOfBurners;

    public Oven(String[] args) {
        super(Double.parseDouble(args[0]), args[1]);
        consumption = Double.parseDouble(args[2]);
        capacity = Double.parseDouble(args[3]);
        weight = Double.parseDouble(args[4]);
        height = Double.parseDouble(args[5]);
        width = Double.parseDouble(args[6]);
        maxDegree = Integer.parseInt(args[7]);
        numOfBurners = Integer.parseInt(args[8]);
    }

    public double getConsumption() {
        return consumption;
    }
    public void setConsumption(double consumption) {
        this.consumption = consumption;
    }

    public double getWeight() {
        return weight;
    }
    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public double getHeight() {
        return height;
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public double getWidth() {
        return width;
    }
    public void setWidth(double width) {
        this.width = width;
    }

    public int getMaxDegree() { return maxDegree; }
    public void setMaxDegree(int degree) { this.maxDegree = maxDegree; }

    public int getNumOfBurners() { return numOfBurners; }
    public void setNumOfBurners(int numOfBurners) { this.numOfBurners = numOfBurners; }


    @Override
    public String toString() {
        return "Oven {" +
                "firm=" + firm +
                " consumption=" + consumption +
                ", capacity=" + capacity +
                ", weight=" + weight +
                ", height=" + height +
                ", width=" + width +
                ", maxDegree=" + maxDegree +
                ", numOfBurners=" + numOfBurners +
                ", price=" + price +
                '}';
    }
}
