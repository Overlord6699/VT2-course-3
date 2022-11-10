package entity;


/**
 * Abstract class that represents base appliance data
 */
public abstract class Appliance {
    protected double price;
    protected String firm;


    public Appliance(final double price, final String firm) {
        this.price = price;
        this.firm = firm;
    }

    public double getPrice() {
        return price;
    }
    public void setPrice(final double price) {
        this.price = price;
    }

    public String getFirm() {
        return firm;
    }
    public void setFirm(final String firm) {
        this.firm = firm;
    }
}