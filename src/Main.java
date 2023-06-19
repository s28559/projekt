import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ContainerShip ship1 = ContainerShip.create(50.0);

        Container refrigeratedContainer = new RefrigeratedContainer(1000.0, 200.0, 28559, 10.0,23.0);
        Container liquidContainer = new LiquidContainer(500.0, 150.0, 28559,50.0,true);
        Container gasContainer = new GasContainer(800.0, 180.0, 28559,50.0, 2.5);

        List <Container> containers = new ArrayList<>();

        try {
            ship1.addContainer(refrigeratedContainer);
            ship1.addContainer(liquidContainer);
            ship1.addContainer(gasContainer);
        } catch (OverfillException e) {
            System.out.println("Error: " + e.getMessage());
        }

        ContainerShip ship2 = ContainerShip.create(60.0);

        try {
            ContainerShip.transferContainers(ship1, ship2, ship1.getContainers());
        }catch (OverfillException e){
            System.out.println("Error: " + e.getMessage());
        }
        containers.add(refrigeratedContainer);
        containers.add(liquidContainer);
        containers.add(gasContainer);
        ship2.removeContainers(containers);
    }
}