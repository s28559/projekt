import java.util.Random;

public class Container {
    double weight;
    double length;
    int serialNumber;
    double maxWeight;

    double height;
    private static final int MAX_SERIAL_NUMBER = 28559;
    private static Random random = new Random();

    {
        generateSerialNumber();
    }

    public Container(double weight, double length, double maxWeight, double height) {
        this.weight = weight;
        this.length = length;
        this.maxWeight = maxWeight;
        this.height=height;
    }

    private void generateSerialNumber() {
        serialNumber = random.nextInt(MAX_SERIAL_NUMBER + 1);
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getLength() {
        return length;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public int getSerialNumber() {
        return serialNumber;
    }

    public double getMaxWeight() {
        return maxWeight;
    }

    public void setMaxWeight(double maxWeight) {
        this.maxWeight = maxWeight;
    }
    public void removeCargo() {
        weight = 0.0;
    }

    public void loadCargo(double weight) throws OverfillException {
        if (weight > maxWeight) {
            throw new OverfillException("Overfill: The cargo weight exceeds the maximum weight limit.");
        }
        this.weight = weight;
    }
}