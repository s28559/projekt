import java.util.ArrayList;
import java.util.List;

public class ContainerShip {
    private List<Container> containers;
    private double maxSpeed;
    private static int maxContainerCount;

    static {
        int index = 28559;
        if (index % 2 == 0) {
            maxContainerCount = index / 2;
        } else {
            maxContainerCount = index / 5;
        }
    }

    private ContainerShip(double maxSpeed) {
        this.containers = new ArrayList<>();
        this.maxSpeed = maxSpeed;
    }

    public static ContainerShip create(double maxSpeed) {
        return new ContainerShip(maxSpeed);
    }

    public void addContainer(Container container) throws OverfillException {
        if (containers.size() >= maxContainerCount) {
            throw new OverfillException("Cannot add more containers. Maximum container count reached.");
        }
        containers.add(container);
    }

    public void addContainers(List<Container> newContainers) throws OverfillException {
        if (containers.size() + newContainers.size() > maxContainerCount) {
            throw new OverfillException("Cannot add more containers. Maximum container count reached.");
        }
        containers.addAll(newContainers);
    }

    public void removeContainer(Container container) {
        containers.remove(container);
    }

    public void removeContainers(List<Container> containersToRemove) {
        containers.removeAll(containersToRemove);
    }

    public void replaceContainer(int position, Container newContainer) {
        if (position >= 0 && position < containers.size()) {
            containers.set(position, newContainer);
        }
    }

    public static void transferContainers(ContainerShip sourceShip, ContainerShip destinationShip, List<Container> containersToTransfer) throws OverfillException {
        destinationShip.addContainers(containersToTransfer);
        sourceShip.containers.removeAll(containersToTransfer);
    }

    public List<Container> getContainers() {
        return containers;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(double maxSpeed) {
        this.maxSpeed = maxSpeed;
    }
}