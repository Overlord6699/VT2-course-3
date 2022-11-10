package entity;

/**
 * Class that represents real kettle
 */
public class Kettle extends Appliance {
    private String type;
    private String color;
    private double capacity;

    public Kettle(String[] args) {
        super(Double.parseDouble(args[0]),args[1]);
        capacity = Double.parseDouble(args[2]);
        type = args[3];
        color = args[4];
    }

    public double getCapacity() {
        return capacity;
    }
    public void setCapacity(double capacity) {
        this.capacity = capacity;
    }

    public String getKettleType(){ return type; }
    public void setKettleType(String type) { this.type = type; }

    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Kettle{" +
                "firm=" + firm +
                ", type=" + type +
                ", color=" + color +
                ", capacity=" +  capacity+
                ", price=" + price +
                '}';
    }
}
