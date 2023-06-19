import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RefrigeratedContainer extends Container {
    private double temperature;
    private List<String> products;
    private static final int index=28559;

    {
        products = new ArrayList<>();
        products.add("ryba");
        products.add("masło");
        products.add("mrożona pizaa");
        products.add("mleko");
    }
    public RefrigeratedContainer(double weight, double length, double maxWeight, double height, double temperature) {
        super(weight, length, maxWeight,height);
        this.temperature = temperature;
    }
    public double getTemperature() {
        return temperature;
    }
    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }
    public List<String> getProducts() {
        return products;
    }
}