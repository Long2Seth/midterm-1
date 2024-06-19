package Main.model;

public class Product {

    private int id;
    private String name;
    private double price_per_unit;
    private int active_for_sale;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public java.lang.String getName() {
        return name;
    }

    public void setName(java.lang.String name) {
        this.name = name;
    }

    public double getPrice_per_unit() {
        return price_per_unit;
    }

    public void setPrice_per_unit(double price_per_unit) {
        this.price_per_unit = price_per_unit;
    }

    public int getActive_for_sale() {
        return active_for_sale;
    }

    public void setActive_for_sale(int active_for_sale) {
        this.active_for_sale = active_for_sale;
    }


}
