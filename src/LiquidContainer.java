public class LiquidContainer extends Container implements Explosible {
    boolean isDangerous;
    public LiquidContainer(double weight, double length, double maxWeight, double height, boolean isDangerous) {
        super(weight, length, maxWeight,height);
        this.isDangerous=isDangerous;
    }
    private boolean isDangerousLiquid() {
        return isDangerous;
    }
    @Override
    public void explode() {
        System.out.println("Liquid container with serial number: " + serialNumber + " exploded!");
    }
    @Override
    public void loadCargo(double weight) throws OverfillException {
        if (isDangerousLiquid()) {
            double maxAllowedWeight = getMaxWeight() / 2.0;
            if (weight > maxAllowedWeight) {
                explode();
                throw new OverfillException("Overfill: The cargo weight of dangerous liquid exceeds the maximum allowed weight.");
            }
        } else {
            double maxAllowedWeight = getMaxWeight() * 0.9;
            if (weight > maxAllowedWeight) {
                throw new OverfillException("Overfill: The cargo weight of safe liquid exceeds the maximum allowed weight.");
            }
        }
        setWeight(weight);
    }
}