public class GasContainer extends Container implements Explosible {
    private double pressure;

    public GasContainer(double weight, double length, double maxWeight, double height, double pressure) {
        super(weight, length, maxWeight, height);
        this.pressure = pressure;
    }

    @Override
    public void removeCargo() {
        double cargoToRemain = getWeight() * 0.05;
        setWeight(cargoToRemain);
    }

    @Override
    public void loadCargo(double cargoWeight) throws OverfillException {
        if (cargoWeight > getMaxWeight()) {
            explode();
            throw new OverfillException("Overfill: The cargo weight exceeds the maximum weight limit.");
        }
        setWeight(cargoWeight);
    }

    @Override
    public void explode() {
        System.out.println("Gas container with serial number: " + serialNumber + " exploded!");
    }
}